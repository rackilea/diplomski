import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.transform.*; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;

public class Test{
 static public void main(String[] arg) throws Exception{

 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 DocumentBuilder builder = factory.newDocumentBuilder();
 Document doc = builder.parse("foo.xml");

 TransformerFactory tranFactory = TransformerFactory.newInstance(); 
 Transformer aTransformer = tranFactory.newTransformer(); 


 NodeList list = doc.getFirstChild().getChildNodes();

 for (int i=0; i<list.getLength(); i++){
    Node element = list.item(i).cloneNode(true);

 if(element.hasChildNodes()){
   Source src = new DOMSource(element); 
   FileOutputStream fs=new FileOutputStream("k" + i + ".xml");
   Result dest = new StreamResult(fs);
   aTransformer.transform(src, dest);
   fs.close();
   }
   }

  }
}