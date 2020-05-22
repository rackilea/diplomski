@IdClass(UserPK.class)
@Table(name = "user")
@Entity
public class User {
    @Id
    private String timeStamp;
    @Id
    private String firstName;
    @Id
    private String lastName;
//remaining fields
// getters and setters
}