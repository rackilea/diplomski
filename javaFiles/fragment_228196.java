import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
public class writexml1 {

public static void main (String args[]) 
{

File docFile = new File("..\\jquery\\WebContent\\demo\\testing.xml");

Document doc = null;
try 
{
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
doc = db.parse(docFile);
} 
catch (java.io.IOException e) 
{
System.out.println("Can't find the file");
} 
catch (Exception e) 
{
System.out.print("Problem parsing the file.");
}

Element root = doc.getDocumentElement();

System.out.println("The root element is " + root.getNodeName() + ".\n");

NodeList children = root.getChildNodes();
System.out.print("There are "+children.getLength()+" child elements.\n");
System.out.print("They are: \n");

//Print the file 
for (Node child = root.getFirstChild();child != null;child = child.getNextSibling())
{
if (child.getNodeType() == child.TEXT_NODE)
{
System.out.println("Text: "+child.getNodeValue());
} 
else if (child.getNodeType() == child.ELEMENT_NODE) 
{
System.out.println(child.getNodeName()+" = "+child.getFirstChild().getNodeValue());
}
}


//NodeList deleteElement = root.getElementsByTagName("staff");

//Node deleteNode= deleteElement.item(0);

//root.removeChild(deleteNode); 
Element staffElement = doc.createElement("staff");

Node updateText = doc.createTextNode("");
staffElement.appendChild(updateText);
//
Element firstName = doc.createElement("firstname");
String str_firstName="added firstname";
Node firstNameNode = doc.createTextNode(str_firstName);
firstName.appendChild(firstNameNode);

staffElement.appendChild(firstName);

//

Element lastName = doc.createElement("lastname");
String str_lastName="added lastname";
Node lastNameNode = doc.createTextNode(str_lastName);
lastName.appendChild(lastNameNode);

staffElement.appendChild(lastName);


//
Element nickName = doc.createElement("nickname");
String str_nickName="added nickname";
Node nickNameNode = doc.createTextNode(str_nickName);
nickName.appendChild(nickNameNode);

staffElement.appendChild(nickName);


//
Element salary = doc.createElement("salary");
String str_salary="$10,000";
Node salaryNode = doc.createTextNode(str_salary);
salary.appendChild(salaryNode);

staffElement.appendChild(salary);


//
root.appendChild(staffElement);

//Node StaffNode=(Node)updateElement;





try{
String outputURL = "..\\jquery\\WebContent\\demo\\testing.xml";

DOMSource source = new DOMSource(doc);
StreamResult result = new StreamResult(new FileOutputStream(outputURL));

TransformerFactory transFactory = TransformerFactory.newInstance();
Transformer transformer = transFactory.newTransformer();

transformer.transform(source, result);

} catch (Exception e) {
e.printStackTrace();
}

}   
   }