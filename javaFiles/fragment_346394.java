@Entity
@Table(name = "boards")
public class Board {


  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true ,  mappedBy = "owner")
  @MapKey(name = "id")
  private Map<UUID, Message> messages = new HashMap<>();

}