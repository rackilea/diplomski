import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

class StudentsToXML {

    public static void main(String[] args) {
        ArrayList <Student> studentList = new ArrayList<>();
        studentList.add(new Student("John", "CA", "123"));
        studentList.add(new Student("Mark", "AZ", "456"));
        exportStudentXML(studentList);    
    }

    public static void exportStudentXML(ArrayList <Student> studentList ){
        DocumentBuilderFactory myDocBuilderFactory = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder myDocBuilder = myDocBuilderFactory.newDocumentBuilder();
            Document documentModel = myDocBuilder.newDocument();

            Element root = documentModel.createElement("studentList");
            documentModel.appendChild(root);

            for (Student thisStudent : studentList){
                Element listElement = documentModel.createElement("student");
                root.appendChild(listElement);

                Element nameElement = documentModel.createElement("name");
                nameElement.appendChild(documentModel.createTextNode(thisStudent.name));
                listElement.appendChild(nameElement);

                Element addressElement = documentModel.createElement("address");
                addressElement.appendChild(documentModel.createTextNode(thisStudent.address));
                listElement.appendChild(addressElement);

                Element ssnElement = documentModel.createElement("ssn");
                ssnElement.appendChild(documentModel.createTextNode(thisStudent.socialSecurityNumber));
                listElement.appendChild(ssnElement);

            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documentModel);
            StreamResult result = new StreamResult(new File("studentlist.xml"));

            transformer.transform(source, result);    
            System.out.println("File saved!");

        }catch(Exception e){
            e.printStackTrace()
        }
    }
}


class Student {

    Student (String name, String addr, String soc) {
        this.name = name;
        address = addr;
        socialSecurityNumber = soc;
    }
    static String name = "";
    static String address = "";
    static String socialSecurityNumber = "";

}