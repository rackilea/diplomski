import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Datas
{
   static ArrayList<String> emptags = new ArrayList<String>();

   static HashMap<String, String> databaseMetadata = new HashMap<String, String>();

   static HashMap<String, String> tagsTometadata = new HashMap<String, String>();

   public void populate(){
      emptags.add("emp_no");

      emptags.add("emp_name");

      emptags.add("emp_sal");



      databaseMetadata.put("NUM","1");
      databaseMetadata.put("NAME","DAVE");
      databaseMetadata.put("SAL","");



      tagsTometadata.put("emp_no","NUM");
      tagsTometadata.put("emp_name","NAME");
      tagsTometadata.put("emp_sal","SAL");
   }

   public static void main(String args[]){
      Datas d = new Datas();
      d.populate();
      System.out.println(emptags);
      try{
         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
         Document doc = docBuilder.newDocument();
         Element rootElement = doc.createElement("emp");
         doc.appendChild(rootElement);
         for(int i=0;i<emptags.size();i++){
            Element newElement = doc.createElement(emptags.get(i));
            if(tagsTometadata.containsKey(emptags.get(i))){
               if(databaseMetadata.containsKey(tagsTometadata.get(emptags.get(i)))){
                  newElement.appendChild(doc.createTextNode(databaseMetadata.get(tagsTometadata.get(emptags.get(i)))));
               }
            }

            rootElement.appendChild(newElement);
         }
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File("C:\\users\\Arun\\Desktop\\file1.xml"));

         // Output to console for testing
         // StreamResult result = new StreamResult(System.out);

         transformer.transform(source, result);

         System.out.println("File saved!");

      }
      catch(Exception e){
         e.printStackTrace();
      }

   }
}