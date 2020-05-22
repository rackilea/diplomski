public class AbstractAuthDao<T> { 

   @PersistenceContext (unitName = "SpringSecurityManager")
   protected EntityManager em;

    ...
}