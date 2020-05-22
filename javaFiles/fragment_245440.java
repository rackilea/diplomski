@Transactional
public E findById(int id) {
    try {
        E instance = (E) sessionFactory.getCurrentSession().get(entity.getClass(), id);
        return instance;
    } catch (RuntimeException re) {
        return null;
    }
}

@SuppressWarnings("unchecked")
@Transactional
public E findByUsername(String username) {
    try {
        E instance = (E) sessionFactory.getCurrentSession().createCriteria(entity.getClass(), username).add(Restrictions.like("login", username)).list().get(0);
        return instance;
    } catch (RuntimeException re) {
        return null;
    }
}

@SuppressWarnings("unchecked")
@Transactional
public List<E> findAll() {
    try {
        List<E> instance = sessionFactory.getCurrentSession().createCriteria(entity.getClass()).list();
        return instance;
    } catch (RuntimeException re) {
        return null;
    }
}