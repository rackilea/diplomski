package jaxb;

import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {

    // I would like this enum in attribute of "Event"
    @XmlType
    @XmlEnum(String.class)
    public enum name {
        @XmlEnumValue("create")
        CREATE, @XmlEnumValue("modify")
        MODIFY, @XmlEnumValue("delete")
        DELETE
    }

    @XmlAttribute(name = "name")
    name eventAttribute;

    public name getEventAttribute() {
        return eventAttribute;
    }

    public void setEventAttribute(name eventAttribute) {
        this.eventAttribute = eventAttribute;
    }

    @XmlElements(value = {
            @XmlElement(type = FTPSendConfiguration.class, name = "FTPSend"),
            @XmlElement(type = SFTPSendConfiguration.class, name = "SFTPSend"),
            @XmlElement(type = MailSendConfiguration.class, name = "MailSend"),
            @XmlElement(type = ServerToServerSendConfiguration.class, name = "ServerToServer") })
    ArrayList<IAction> actionsList = new ArrayList<IAction>();

    public Event() {

    }

    public ArrayList<IAction> getActionsList() {
        return actionsList;
    }

    public void setActionsList(ArrayList<IAction> actionsList) {
        this.actionsList = actionsList;
    }

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Event.class);
        Event e = new Event();
        e.eventAttribute = name.CREATE;  // I set this field using the enum (it could be set to name.DELETE or name.MODIFY as well)
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(e, System.out);
    }
}