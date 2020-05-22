public class EMFactory implements Factory<EntityManager> {
    private final EntityManagerFactory emf;
    private final CloseableService closeService;

    @Inject
    public EMFactory (EntityManagerFactory emf, CloseableService closeService){
        this.emf = emf;
        this.closeService = closeService;
    }
    public EntityManager provide() {
        final EntityManager em = emf.createEntityManager();
        this.closeService.add(new Closeable(){
            @Override
            public void close() {
                em.close();
            }
        });
        return em;
    }
    ...
}