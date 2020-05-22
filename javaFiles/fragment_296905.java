package forum987537;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Notification", namespace="http://soap.sforce.com/2005/09/outbound")
public class Notification {

    private SObject sObject;

    @XmlElement(namespace="http://soap.sforce.com/2005/09/outbound")
    public SObject getsObject() {
        return sObject;
    }

    public void setsObject(SObject sObject) {
        this.sObject = sObject;
    }

}