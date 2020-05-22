@Named
@Stateless
public class MyDAO {

@PersistenceContext(unitName = "SRA")
private EntityManager em;

public void save(Object o) {
    em.persist(o);
    em.flush();
}