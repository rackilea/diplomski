import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DataBroker<T> {

    private EntityManager em;

    public DataBroker() {
        if(em == null) {
            em = Persistence.createEntityManagerFactory("ProjectPU").createEntityManager();
        }
    }

    public void saveInput(T t) {
        em.merge(t);
    }


}