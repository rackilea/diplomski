@Entity
public class Company {

    // no-arg constructor
    Company() { }

    // normal use constructor
    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Version
    private int versionId;

    //@OneToMany(cascade=CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="company_person",  
    joinColumns={@JoinColumn(name="company_id", referencedColumnName="id")},  
    inverseJoinColumns={@JoinColumn(name="person_id", referencedColumnName="id")})  
    private List<Person> personList;  

    // Getters / Setters
}