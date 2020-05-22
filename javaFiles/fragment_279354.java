import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Download.class);

        Download download = new Download();
        QName qname = new QName("HTTP://xyz.abc.Com//Vendor/DownloadWSE.xsd";
        JAXBElement<Download> jaxbElement = new JAXBElement(qname, "Download"), Download.class, download);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(jaxbElement, System.out);
    }
}