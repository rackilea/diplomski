public class MainApp {

   public static void main(String[] args) {

      Session session = null;
      Transaction transaction = null;
      try {
         session = HibernateUtil.getSessionFactory()
               .withOptions()
               .interceptor(new LoggingInterceptor()) // add Logging_interceptor to Session
               .openSession();

         transaction = session.getTransaction();
         transaction.begin();

}