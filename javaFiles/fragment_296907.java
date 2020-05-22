package forum987537;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Notification.class);

        Notification notification = new Notification();
        Opportunity opportunity = new Opportunity();
        opportunity.setId("ABC123");
        notification.setsObject(opportunity);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(notification, System.out);
    }

}