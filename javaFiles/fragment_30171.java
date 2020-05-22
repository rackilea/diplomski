@Named
@PersistenceContext(unitName = "com.mycompany_mavenproject1_war_1.0-SNAPSHOTPU", name = "persistence/em")
public class OrderWriter extends AbstractItemWriter {

    EntityManager em;

    @Override
    public void open(Serializable checkpoint) {
        try {
            InitialContext ic = new InitialContext();
            em = (EntityManager) ic.lookup("java:comp/env/persistence/em");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeItems(List<Object> list){

        for (Object p : list) {                
            em.merge(p);
        }
    }
}