@Entity
public class Role{

    // ---- JPA attributes
    @Id
    // ...
    @Column(...)
    private Long roleId;

    @OneToMany(mappedBy = "role")
    private List<Person> personsWithThisRoleAsPrimaryRole;

    @OneToMany(mappedBy = "parentRole")
    private List<Person> personsWithThisRoleAsParentRole;

    // ---- Constructor
    public Role(){
        // your initialisation

        // initialise list to avoid NullPointerException
        this.personsWithThisRoleAsPrimaryRole = new ArrayList<>();
        this.personsWithThisRoleAsParentRole = new ArrayList<>();

    }

    // getters & setters
}