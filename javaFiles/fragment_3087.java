@Entity
@Table(name = "mytable2")
public class EntityTwo {
  // other code omitted ...
  @OneToMany(mappedBy = "entityTwo", fetch = FetchType.EAGER, 
    cascade = {CascadeType.ALL}, orphanRemoval = true)
  @MapKey(name = "identifier")
  private Map<String, EntityOne> entityOnes = new HashMap<>();
}