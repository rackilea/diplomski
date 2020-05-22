@XmlRootElement(name="TransactionBlk_REQ",namespace="http://TransactionBlk.com")
@XmlAccessorType(XmlAccessType.FIELD)  
public class TransactionBlk  
{ 
   @XmlElement(name = "Id")
   private String id;  

   @XmlElement(name = "Originator")
   private String Originator;   

   //Your getter and setter method.
}

TransactionBlk bean = new TransactionBlk();
//Set your parameter value here

StringWriter responseWriter = new StringWriter();  
JAXBContext jaxbContext = JAXBContext.newInstance(TransactionBlk.class);
Marshaller jaxbMarshaller = jaxbContext.createMarshaller();  
jaxbMarshaller.marshal(bean, responseWriter);
String xmlStr = responseWriter!=null?responseWriter.toString():null;