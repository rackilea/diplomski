import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.docx4j.XmlUtils;
import org.pptx4j.jaxb.Context;
import org.pptx4j.pml.CTGraphicalObjectFrame;

public class FileToPML {
public static void main(String[] args) throws Exception {

    String inputfilepath = System.getProperty("user.dir") + "/pml.xml";
    java.io.FileInputStream fin = new java.io.FileInputStream(inputfilepath);

    // Create Unmarshaller
    JAXBContext jc = Context.jcPML;
    Unmarshaller u = jc.createUnmarshaller();
    u.setEventHandler(new org.docx4j.jaxb.JaxbValidationEventHandler());

    // Unmarshall, giving JAXB a hint
    Object o = u.unmarshal(new javax.xml.transform.stream.StreamSource(fin), 
            CTGraphicalObjectFrame.class);

    // Prove it worked
    System.out.println(o.getClass().getName());
    System.out.println(XmlUtils.marshaltoString(o, Context.jcPML));

}

}