@PostConstruct
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public void insertTestData(){
    Session session = sf.openSession();

    session.persist(new Site("site one"));
    session.persist(new Site("site two"));
    session.flush();
    session.close();
}