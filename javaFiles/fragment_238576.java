@Entity
@Table(name = "USER_ROLE")
public class UserRole {
    ... // id, additional columns go here

    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id") 
    private Role role;
    ...