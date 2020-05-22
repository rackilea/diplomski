@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlValue
    private String address = null;

    @XmlAttribute(name="type")
    private String type = null;

}