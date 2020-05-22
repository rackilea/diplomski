@XmlRootElement(name = "dataCase")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataStorage {
    @XmlPath("data/innerData/data1/text()")
    private String data1;
    @XmlPath("data/otherData/@data2")
    private String data2;
    @XmlPath("data/otherData/data3/text()")
    private String data3;
....