package forum11417620;

import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="Person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlElement(name="FirstName")
    private String firstName;

    @XmlElement(name="LastName")
    private String lastName;

    @XmlElement(name="Occupation")
    private String occupation;

    @XmlPath("Gender/@tc")
    private String genderTC;

    @XmlPath("Gender/text()")
    private String gender;

    @XmlElement(name="BirthDate")
    private String birthDate;

    @XmlElement(name="Age")
    private int age;

}