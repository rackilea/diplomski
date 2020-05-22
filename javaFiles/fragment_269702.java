import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLReader {

    private HashMap<String,ArrayList<String>> namesSentencesMap;

    public XMLReader() {
        namesSentencesMap = new HashMap<String, ArrayList<String>>();
    }

    private Document getDocument(String fileName){
        Document document = null;

        try{
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(fileName));
        }catch(Exception exe){
            //handle exception
        }

        return document;
    }

    private void buildNamesSentencesMap(Document document){
        if(document == null){
            return;
        }

        //Get each Turn block
        NodeList turnList = document.getElementsByTagName("Turn");
        String fromName = null;

        NodeList sentenceNodeList = null;
        for(int turnIndex = 0; turnIndex < turnList.getLength(); turnIndex++){
            Element turnElement = (Element)turnList.item(turnIndex);
            //Assumption: <From> element
            Element fromElement = (Element) turnElement.getElementsByTagName("From").item(0); 
            fromName = fromElement.getTextContent();
            //Extracting sentences - First check whether the map contains 
            //an ArrayList corresponding to the name. If yes, then use that,  
            //else create a new one                                              
            ArrayList<String> sentenceList = namesSentencesMap.get(fromName);
            if(sentenceList == null){
                sentenceList = new ArrayList<String>();
            }
            //Extract sentences from the Turn node
            try{
                sentenceNodeList = turnElement.getElementsByTagName("Sentence");
                for(int sentenceIndex = 0; sentenceIndex < sentenceNodeList.getLength(); sentenceIndex++){
                    sentenceList.add(((Element)sentenceNodeList.item(sentenceIndex)).getTextContent());
                }
            }finally{
                sentenceNodeList = null;
            }
            //Put the list back in the map                  
            namesSentencesMap.put(fromName, sentenceList);
        }
    }

    public static void main(String[] args) {
        XMLReader reader = new XMLReader();
        reader.buildNamesSentencesMap(reader.getDocument("<your_xml_file>"));

        for(String names: reader.namesSentencesMap.keySet()){
            System.out.println("Name: "+names+"\tTotal Sentences: "+reader.namesSentencesMap.get(names).size());
        }
    }
}