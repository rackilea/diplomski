@XmlAccessorType(XmlAccessType.FIELD) 
public class Document {
    @XmlElement
    private String title;
    @XmlElement
    private String id;
    @XmlElement
    private int version;
}  


@XmlAccessorType(XmlAccessType.FIELD)
public class MapJson {
    @XmlElement
    private LinkedHashMap<String, String> documents; 
}