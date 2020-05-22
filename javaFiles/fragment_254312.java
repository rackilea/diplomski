public class ServiceDaoImpl{

    @PersistenceContext (unitName="fb-persistence")
    private EntityManager em;

    @Transactional(readOnly=false)
    public void write(Service entity){
        em.persist(entity);
        em.flush();
    }

}