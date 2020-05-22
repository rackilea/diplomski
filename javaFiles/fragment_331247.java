@Component("Dao")
public class Dao implements IDao  {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public <T> T save(final T o){
        return (T) sessionFactory.getCurrentSession().save(o);
    }

    @Override
    public void delete(final Object object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public <T> T get(final Class<T> type, final Long id) {
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public <T> List<T> getFieldsEq(final Class<T> type, final Map<String, Object> restrictions) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        for (Map.Entry<String, Object> entry : restrictions.entrySet()) {
            crit.add(Restrictions.eq(entry.getKey(), entry.getValue()));
        }

        return crit.list();
    }
}