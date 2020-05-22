@Entity
public class User extends Model {
    public enum Role {
        User,
        Moderator,
        Admin,
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('User', 'Moderator', 'Admin')")
    public Role role;
}