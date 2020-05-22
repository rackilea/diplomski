@Entity
@Table(name = "focusoc_orbit")
public class OrbitAdapter extends Adapter{

  @Id
  private String              id;

  ...

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  ...

}