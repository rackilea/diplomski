import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Id {

    @XmlAttribute(namespace="http://itunes.apple.com/rss")
    private String id;

    @XmlValue
    private String value;

}