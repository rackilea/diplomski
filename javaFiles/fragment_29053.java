@Entity // JPA
@XmlRootElement(name = "book") // JAXB
@SuppressWarnings(value = "random") // whatever other annotation
public class User  {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "incremental", strategy = "increment")
    @XmlElement
    private Long userID;

    // more
}