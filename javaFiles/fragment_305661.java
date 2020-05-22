package forum8406266;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Folder.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        List<Folder> folders = new ArrayList<Folder>(3);
        folders.add(new Folder());
        folders.add(new Folder());
        folders.add(new Folder());

        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        XMLStreamWriter xsw = xof.createXMLStreamWriter(System.out);
        xsw.writeStartDocument();
        xsw.writeStartElement("Folders");

        for(Folder folder : folders) {
            marshaller.marshal(folder, xsw);
        }

        xsw.writeEndElement();
        xsw.writeEndDocument();
        xsw.flush();
    }

}