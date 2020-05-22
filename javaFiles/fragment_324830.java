@Entity(name = "User")
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
@SecondaryTable(name = "user_picture")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String name;
    private String password;
    @Lob
    @Column(table = "users_picture", length = 524288)
    private byte[] picture;
    private Date birthDate;
    private String phonenumber;
    @ManyToOne(fetch = FetchType.EAGER)
    private Address homeAddress;
    @Enumerated(EnumType.STRING)
    private Gender gender;  
    @CollectionOfElements(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Weekday> workdays = new HashSet<Weekday>();