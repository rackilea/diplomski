@Entity
public class PersonsDomain {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "PersonID")
private int personId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "Age")
    private int age;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "personId", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<ContactDomain> contactDomain;

    @OneToMany
    private Set<AddressDomain> addressDomain;
}