@Autowired
private SessionFactory sessionFactory;

public void save(YourEntity entity) {
    sessionFactory.getCurrentSession().save(entity);
}