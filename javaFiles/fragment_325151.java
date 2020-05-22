package forum11465653;

import java.io.FileReader;
import javax.xml.bind.*;
import javax.xml.stream.*;

public class Demo {

    public static void main(String[] args) throws Exception{
        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("src/forum11465653/input.xml"));
        xsr.nextTag(); // Advance to Envelope tag
        xsr.nextTag(); // Advance to Body tag
        xsr.nextTag(); // Advance to getNumberResponse tag
        System.out.println(xsr.getNamespaceContext().getNamespaceURI("ns"));

        JAXBContext jc = JAXBContext.newInstance(Response.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<Response> je = unmarshaller.unmarshal(xsr, Response.class);
        System.out.println(je.getName());
        System.out.println(je.getValue());
    }

}