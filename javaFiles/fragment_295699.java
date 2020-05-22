import java.io.File;
import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();

        XMLInputFactory xif = XMLInputFactory.newFactory();
        File outputFile = new File("input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(outputFile));
        BlastOutput blastOutput = demo.unmarshalBlastOutput(xsr);
    }

    private BlastOutput unmarshalBlastOutput(XMLStreamReader xsr) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(BlastOutput.class);
        Unmarshaller u = jc.createUnmarshaller();
        return (BlastOutput) u.unmarshal(xsr);
    }

}