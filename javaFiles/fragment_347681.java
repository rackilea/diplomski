@Entity(name = "users")
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(name = "users_unique_username_idx", columnNames = "username"),
    @UniqueConstraint(name = "users_unique_email_idx", columnNames = "email")
})
public class User extends BaseEntity { ... }