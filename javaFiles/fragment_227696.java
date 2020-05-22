import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource source = new StreamSource("input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(source);

        while(xsr.hasNext()) {
            if(xsr.isStartElement() && "FooId".equals(xsr.getLocalName())) {
                long value = Long.valueOf(xsr.getElementText());
                System.out.println(value);
            }
            xsr.next();
        }

        xsr.close();
    }

}