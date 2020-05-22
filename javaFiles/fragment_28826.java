@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="SSO-Request")
public class SSORequest {

    @XmlElement(name="User-Id")
    String userId;

    @XmlElementWrapper(name="Former-User-Ids")
    @XmlElement(name="User-Id")
    List<String> formerUserIds;
}