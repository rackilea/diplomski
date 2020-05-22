package forum12402215;

import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Bork.class.getClassLoader();
        JAXBContext jc = JAXBContext.newInstance(Bork.class, Gnarf.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        StreamSource source = new StreamSource("src/forum12402215/input.xml");
        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(source);
        xsr.nextTag(); // Advance to "foo" element
        xsr.nextTag(); // Advance to "bar" element

        while(xsr.getLocalName().equals("bar")) {
             String className = xsr.getAttributeValue("", "class");
             Class<?> clazz = classLoader.loadClass(className);
             Object object = unmarshaller.unmarshal(xsr, clazz).getValue();
             System.out.println(object);
             xsr.nextTag();
        }
    }

}