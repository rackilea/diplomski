@Repository
public class UserRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void lockUser(final Long id, final boolean wait) throws InterruptedException {
        entityManager.clear(); // be sure there is nothing in the cache, actually the threads don't share first level cache

        final Map<String, Object> props = new HashMap<String, Object>();
        props.put("javax.persistence.query.timeout", 0);

        System.out.println("Thread " + Thread.currentThread().getId() + " EXECUTES SELECT FOR UPDATE");
        entityManager.find(User.class, id, LockModeType.PESSIMISTIC_WRITE, props);

        if (wait) {
            System.out.println("Thread " + Thread.currentThread().getId() + " started blocking!");
            Thread.sleep(10000);
            System.out.println("Thread " + Thread.currentThread().getId() + " finished blocking!");
        }

        System.out.println("Thread " + Thread.currentThread().getId() + " FINISHED QUERY");
    }
}