@Entity
public class Event {
  @Id Integer id;

  @OneToMany(cascade = CascadeType.PERSIST, mappedBy="successor")
  private Collection<Chain> predecessorChains;
}