@Autowired
private SessionFactory sessionFactory;

@Transactional
public void someMethod() {
    // get the session for the current transaction:
    Session session = sessionFactory.getCurrentSession();
    // do things with the session (queries, merges, persists, etc.)
}