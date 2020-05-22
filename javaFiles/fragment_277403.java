@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;
}