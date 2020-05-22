import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import java.io.IOException;

public class Xml {
    public static void main(String[] args) throws IOException {
     // Important: create XmlMapper; it will use proper factories, workarounds
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        xmlMapper.writeValue(System.out, new SampleRequest());
    }
}

class SampleRequest{
    public int x = 1;
    public int y = 2;
}