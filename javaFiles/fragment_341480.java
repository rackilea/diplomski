@Entity
public class Wrapper {
  @Id
  private String id;
  private User user;
  private Resource resource;
  private Privilege privilege;


// constructors
  public Wrapper(final User user, final Resource resource, final Privilege privilege) {
    this.user = user;
    this.resource = resource;
    this.privilege = privilege;
  }
}