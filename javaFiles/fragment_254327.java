import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlElement(name = "Id")
    private int id;

}