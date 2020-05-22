@Stateless
public class YourSessionBean implements RemoteInterface {

     @PersistenceContext
     private EntityManager entityManager; // this is the JPA EntityManager
}