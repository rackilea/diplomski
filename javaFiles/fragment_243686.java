package forum7534500;

import java.io.StringWriter;
import java.util.Hashtable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Wrapper.class);
        Wrapper wrapper = new Wrapper();
        Hashtable<String, String> hashtable = new Hashtable<String,String>();
        hashtable.put("foo", "A");
        hashtable.put("bar", "B");
        wrapper.setHashtable(hashtable);
        System.out.println(objectToXml(jc, wrapper));
    }

    public static String objectToXml(JAXBContext jaxbContext, Object object) throws JAXBException
    {
      StringWriter writerTo = new StringWriter();
      Marshaller marshaller = jaxbContext.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
      marshaller.marshal(object, writerTo); //create xml string from the input object
      return writerTo.toString();
    }

}