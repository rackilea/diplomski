@NamedNativeQuery(
    name="complexQuery",
    query="SELECT USER.* FROM USER_ AS USER WHERE ID = ?",
    resultClass=User.class
)
public class User { ... }

Query query = em.createNamedQuery("complexQuery", User.class);
query.setParameter(1, id);
User user = (User) query.getSingleResult();