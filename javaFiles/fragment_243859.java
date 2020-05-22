@Entity
public class Person{

    // ---- JPA attributes
    @Id
    // ...
    @Column(...)
    private Long personId;

    @ManyToOne
    @JoinColumn(name = "RoleId")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "ParentRoleId")
    private Role parentRole;

    // ---- Transient attributes
    @Transient
    private List<Person> personsWithParentRole;

    @Transient
    private List<Person> personsWhoseRoleHasCurrentPersonRoleAsParent;

    // ---- Constructor

    public Person(){
        // your initialisation

        // initialise list to avoid NullPointerException
        this.personsWithParentRole = new ArrayList<>();
        this.personsWhoseRoleHasCurrentPersonRoleAsParent = new ArrayList<>();
    }

    @PostLoad
    public void postLoad(){
        // during JPA initialisation, role and parentRole have been defined
        // if the value exist in the database. Consequently, we can fetch some
        // interesting info:
        if(role != null){
            personsWithParentRole.addAll(role.getPersonsWithThisRoleAsParentRole());
        }
        if(parentRole != null){
            personsWhoseRoleHasCurrentPersonRoleAsParent.addAll(parentRole.getPersonsWithThisRoleAsPrimaryRole());
        }
    }

    // getters and setters for JPA attributes

    // getters for transient attributes. It doesn't make sense to create the setters for the transient list here.
}