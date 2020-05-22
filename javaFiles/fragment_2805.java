package forum11410653;

import java.io.*;
import javax.xml.bind.*;
import com.thoughtworks.xstream.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        EstateDTO estateDTO = new EstateDTO("Hotel", "StreetOne", 1, 111111,
                "England", 1);

        // setting up xstream
        XStream xstream = new XStream();
        xstream.processAnnotations(EstateDTO.class);
        xstream.autodetectAnnotations(true);

        xstream.setClassLoader(new EstateDTO().getClass().getClassLoader());
        xstream.alias("estateDTO", EstateDTO.class);
        xstream.alias("estateId", Integer.class);
        xstream.alias("estateName", String.class);
        StringWriter writer = new StringWriter();
        xstream.toXML(estateDTO, writer);

        String xml = writer.toString();
        System.out.println(xml);

        // setting up JAXB
        JAXBContext jc = JAXBContext.newInstance(EstateDTO.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        EstateDTO unmarshalled = (EstateDTO) unmarshaller
                .unmarshal(new StringReader(xml));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(unmarshalled, System.out);
    }

}