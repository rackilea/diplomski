@Entity
@Table(name = "MyUser")
public class User {
    @Id
    @GeneratedValue
    private long userId;