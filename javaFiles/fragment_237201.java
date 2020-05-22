@Entity
@Table(name="passwords")
public class Password {
  @Id
  User user;
  // ...
}