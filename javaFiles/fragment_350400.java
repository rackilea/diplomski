@XmlAccessorType(XmlAccessType.FIELD)
public class Media {

    @XmlAttribute
    private String id;
    @XmlAttribute
    private String start;
    @XmlAttribute
    private String finish;
    @XmlAttribute
    private String timeZone;

    @XmlElements ({
        @XmlElement(name="tag", type = MediaTag.class),
        @XmlElement(name="trajectory", type = CommonObjectsOfMedia.class),
        @XmlElement(name="count", type = MediaCount.class),
    })
    private List<CommonObjectsOfMedia> commonObjectsOfMedia;
}