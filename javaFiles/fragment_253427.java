public abstract class AbstractInsertable<T> extends ... {
    public boolean insert(T t) {
        Session session = null;
        try {
            session = super.getConnection();
            session.getTransaction().begin();
            session.save(t);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection(session);
        }
    }

    [...]
}