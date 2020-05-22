public class Service {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        return (List<User>) query.list();
    }

}