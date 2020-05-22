@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy="myself")
    private Set<AssocUserUser> contacts;

@Entity
public class AssocUserUser {
    @EmbeddedId
    private AssocUserUserId id = new AssocUserUserId();
    @ManyToOne @MapsId("myselfId")
    private User myself;
    @ManyToOne @MapsId("contactId")
    private User contact;

@SuppressWarnings("serial")
@Embeddable
public class AssocUserUserId implements Serializable {
    private Long myselfId;
    private Long contactId;