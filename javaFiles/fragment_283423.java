package test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main{
  public static void main(String[] args)
  {
    try {
      JAXBContext objContext = JAXBContext.newInstance(Response.class);
      Marshaller objMarshaller = objContext.createMarshaller();
      objMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      MessageResponse mr = new MessageResponse("", "");
      objMarshaller.marshal(mr, System.out);
    } catch (JAXBException e) {
       e.printStackTrace();
    }
  }
}