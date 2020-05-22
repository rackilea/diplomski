@XmlAccessorType(XmlAccessType.FIELD)
public class Column {

    @XmlAttribute
    private String type;
    @XmlAttribute
    private String index;
    @XmlValue
    private String value;
}