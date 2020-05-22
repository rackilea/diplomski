@Entity
@Table(name = "o2_branch", catalog = "o2plus"
)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@JsonIgnoreProperties(value = {"active", "modifiedBy", "modifiedTimestamp", "members", "staff"})
public class Branch implements java.io.Serializable {

    private Long id;
    private Address address;
    private String name;
    private String contactNumber;
    private Integer capacity;
    private String manager;
    private boolean active;
    private String modifiedBy;
    private Date modifiedTimestamp;
    private Set<Member> members = new HashSet<Member>(0);
    private Set<Staff> staff = new HashSet<Staff>(0);