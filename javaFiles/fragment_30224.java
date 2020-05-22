import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

JAXBContext jc = JAXBContext.newInstance("test.jaxb");
Unmarshaller unmarshaller = jc.createUnmarshaller();
unmarshaller.unmarshal(soapBody);