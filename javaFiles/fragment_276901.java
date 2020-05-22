@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    public EntityManager getEntityManager {
        return entityManager;
    }

    public void closeEntityManager(@Disposes EntityManager em) {
        if (em != null && em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

}