@Entity
public class ModuleRole {

    private Long id;

    private Set<User> users;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @ManyToMany
    @JoinTable(name = "user_module_role", 
        joinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"), referencedColumnName = "id")
    public Set<Users> getUsers() {
        return users;
    }

}

@Entity
@Table(name = "user")
public class User{
    private Long id;
    private Set<ModuleRole> moduleRoles;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @ManyToMany(mappedBy = "users")
    public Set<ModuleRole> getModuleRoles() {
        return moduleRoles;
    }

}