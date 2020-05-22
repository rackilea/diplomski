public class CreateXmlDemo {

private static String fileLocation = null;
public static void main(String[] args) {
    fileLocation = "D:\\Faiz\\output.xml";
    CreateXmlDemo c1 = new CreateXmlDemo();
    c1.createXmlFile();

    CreateXmlDemo c2 = new CreateXmlDemo();
    CreateXmlDemo c3 = new CreateXmlDemo();
    CreateXmlDemo c4 = new CreateXmlDemo();

    CreateXmlDemo[] items= {c2,c3,c4};
    for(CreateXmlDemo item : items){
        item.writeXml();
    }
    c1.prettyPrint();
}

public void createXmlFile(){
    try{
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("ITEMS");
        doc.appendChild(rootElement);
        writeWithoutIndentation(doc);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

public void writeXml(){

    try{
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(fileLocation);
        doc.normalize();
        Element rootElement = doc.getDocumentElement();
        Element item = doc.createElement("ITEM");           
        Element id = doc.createElement("ID");
        id.appendChild(doc.createTextNode("1"));
        item.appendChild(id);

        Element name = doc.createElement("Name");
        name.appendChild(doc.createTextNode("James"));
        item.appendChild(name);

        rootElement.appendChild(item);
        rootElement.normalize();
        writeWithoutIndentation(doc);
        }catch(Exception e){
            e.printStackTrace();
    }
}

public void writeWithoutIndentation(Document doc){
    try{
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(fileLocation));
        transformer.transform(source, result);
    }catch(Exception e){
        e.printStackTrace();
    }
}

public void prettyPrint(){
    try{
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(fileLocation);
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(fileLocation));

        transformer.transform(source, result);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}