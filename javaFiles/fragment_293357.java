public interface GreatDAO {
    User getUser(int id);
    void saveUser(User u);
}
public class TheGreatestDAO implements GreatDAO {
   protected TheGeatestDAO(){}
   ... 
}
public class GreatDAOFactory {
     private static GreatDAO dao = null;
     protected static synchronized GreatDao setDAO(GreatDAO d) {
         GreatDAO old = dao;
         dao = d;
         return old;
     }
     public static synchronized GreatDAO getDAO() {
         return dao == null ? dao = new TheGreatestDAO() : dao;
     }
}

public class App {
     void setUserName(int id, String name) {
          GreatDAO dao =  GreatDAOFactory.getDao();
          User u = dao.getUser(id);
          u.setName(name);
          dao.saveUser(u);
     }
}