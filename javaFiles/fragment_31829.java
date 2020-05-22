@Path("/hello")
public class Controller {

  @PersistenceContext(unitName="Simplest")
  private EntityManager em;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayHello() {
      // get Media from database - replace with your own code
      Media media = em.find(Media.class, "1");
      return media.getDescription();
  }
}