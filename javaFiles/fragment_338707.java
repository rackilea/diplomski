@Repository
public class SomeRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public MyEntity readAndModify(Long key) {
        MyEntity myEntity = em.find( key, MyEntity.class);
        myEntity.setSomeField(...); // this will trigger update via dirty checking
        return myEntity;
    }
}