@Repository("LoginDetailsDAO")
@Transactional
public class LoginDetailsDAOImpl extends HomeSessionFactory implements LoginDetailsDAO {
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<UserLogin> loginDetails(UserLogin login) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserLogin> result = session.createQuery("from UserLogin").list();
        transaction.commit();
        return result;
    }
}