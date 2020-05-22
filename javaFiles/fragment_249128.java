import org.hibernate.SessionFactory;
    import org.hibernate.Session;
    import org.hibernate.Transaction;
    import org.hibernate.cfg.Configuration;
    public class UserDao {
    private static SessionFactory factory;
    public static int register(Register u){
        int i=0;

        factory = getSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();
        t.begin();

        i=(Integer)session.save(u);
        t.commit();
        session.close();
        return i;
    }



public static SessionFactory getSessionFactory(){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        if(factory==null)
         factory = cfg.buildSessionFactory();

        return factory;
    }
  }