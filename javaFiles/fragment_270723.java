@Entity
public class Person {

    // no-arg constructor
    Person() { }

    // normal use constructor
    public Person(String name, String address) {
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

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="company_person",  
    joinColumns={@JoinColumn(name="person_id", referencedColumnName="id")},  
    inverseJoinColumns={@JoinColumn(name="company_id", referencedColumnName="id")})  
    private List<Company> companyList;  

    // Getters / setters

}