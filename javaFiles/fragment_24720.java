import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Arrays;
public class JAXBxml {

    public static void main(String[] args) {
       MyOrganisation myOrg = new MyOrganisation();
        try {
            JAXBContext context = JAXBContext.newInstance(myOrg.getClass());
            StringWriter writer = new StringWriter();
            writer.append("<?xml version=\"1.0\"?>");
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

            myOrg.setDepartmentName("Cognizant");
            myOrg.setEmployeeID(140012);
            myOrg.setDepartmentName("Vishwa Ratna");
            myOrg.setTasks(Arrays.asList("Coding","Deployment","Production"));

            marshaller.marshal(myOrg, writer);
            String stringXML = writer.toString();
            System.out.println(stringXML);

        } catch (JAXBException e) {
            throw new RuntimeException("Problems generating XML in specified "
                    + "encoding, underlying problem is " + e.getMessage(),
                    e);
        }
    }
}