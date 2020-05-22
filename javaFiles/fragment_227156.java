@Path("/v1/items")
public class ItemsService {

    @Inject
    private EntityManager entityManager;

    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void saveItem(){
         entityManager.getTransaction().begin();
         entityManager.persist(new Item());
         entityManager.getTransaction().commit();
    }
}