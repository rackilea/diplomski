@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String surname;
    @Column(name = "password")
    private String password;
    @ManyToMany
    @JoinTable(name = "friends", joinColumns = @JoinColumn(name = "who"), inverseJoinColumns = @JoinColumn(name = "with"))
    private List<User> friends;
}