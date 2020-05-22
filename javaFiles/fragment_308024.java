public class HibernateUtils{
    private static SessionFactory session;

    private static void createSession(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    public static Session getSession(){
         if(session == null)
             createSession()
         return session.openSession();
    }
}