public class ServiceImp implements Service {

    private EntityManagerFactory emf;
    private EntityManager em;

    public Service() {
        super();
        emf = Peristence.createEntityManagerFactory("YourPU");
    }

    @Override
    public EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        return em;
    }
}