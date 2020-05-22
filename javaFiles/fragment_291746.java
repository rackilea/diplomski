@XmlAccessorType(value = XmlAccessType.NONE)
@Entity
public class AuthInfo{
    @XmlElement
    private String auth;

    @XmlElement
    private String token;
}