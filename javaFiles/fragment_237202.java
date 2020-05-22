@Entity
@Table(name="passwords")
public class Password {
  @Id
  int userId;

  @MapsId
  @OneToOne
  @JoinColumn(name = "user_id")
  User user;
  // ...
}