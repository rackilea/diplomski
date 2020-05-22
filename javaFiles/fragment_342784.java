@Entity
@Table(name = "user")
public class User {
  @OneToMany(mappedBy = "user")
  private List<Board> boards;

}