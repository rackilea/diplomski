import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlPath("name/firstname/text()")
    private String firstName;

    @XmlPath("name/lastname/text()")
    private String lastName;

    // ...
}