public class HibernateUtil {
    private static EntityManagerFactory emFactory;
    private static EntityManager em;
    private static final Logger log = LoggerFactory.getLogger(HibernateUtil.class);
    private static final String PERSISTENCE_UNIT = "pt";
    static{
        log.info("Creating entity manager factory");
        emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }
    //calling this from main before PersonDao's method calls somehow works...
    public void init(){} //does nothing
    public static EntityManager getEntityManager(){
        if(em != null && em.isOpen()){
            closeEntityManager();
        }
        log.debug("Creating new entity manager");
        em = emFactory.createEntityManager();
        return em;
    }
    public static void close() throws Exception {
        if(em != null && em.isOpen()){
            closeEntityManager();
        }
        log.info("Closing entity manager factory");
        emFactory.close();
    }
    private static void closeEntityManager(){
        log.info("Closing last entity manager");
        em.close();
    }
}