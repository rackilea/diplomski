@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyRow {

    @XmlAttribute
    private String index;

    @XmlElement(name = "col")
    private List<Column> columns;
}