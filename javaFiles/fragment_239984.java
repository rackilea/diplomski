public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory；

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}