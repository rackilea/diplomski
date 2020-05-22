@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractCrudApi<T> {

    @PersistenceContext
    private EntityManager em;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String create(@Form T entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return "{\"success\":false, \"msg\":\"Error occured, please  try later\"}";
        }
        return "{\"success\":true, \"msg\": \"Saved successfully\"}";
    }
}