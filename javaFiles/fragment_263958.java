public class EMFFactory implements Factory<EntityManagerFactory> {
    private final EntityManagerFactory emf;
    public EMFFactory (){
        emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }
    public EntityManagerFactory provide() {
        return emf;
    }
    ...
}

public class EMFactory implements Factory<EntityManager> {
    private final EntityManager em;

    @Inject
    public EMFactory (EntityManagerFactory emf){
        em = emf.createEntityManager();
    }
    public EntityManager provide() {
        return em;
    }
    ...
}