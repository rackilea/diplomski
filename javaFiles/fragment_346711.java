@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserApp extends Role {

    private String name;
    private String password;
    private int active;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns =
            @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public UserApp(UserApp userApp) {

    }
}