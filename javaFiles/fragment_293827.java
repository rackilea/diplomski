public class UserDao {

    public Session getSession() {
      return HibernateUtil.getSession();
    }

    public void closeSession() {
      HibernateUtil.closeSession();
    }

    public void addUser(User u) {    
        Session session = getSession();
        Transaction t = session.beginTransaction();
        int i = (Integer)session.save(u);
        t.commit();
        closeSession();
    }
}