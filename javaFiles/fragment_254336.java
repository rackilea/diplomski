public class Emf {

  private static Emf theInstance = null;
  private  EntityManagerFactory entityManagerFactory = null;

  private Emf() {
      try {
           entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit", System.getProperties());
           //InitialContext context = new InitialContext();
          } catch (Exception e) {
              // TODO Auto-generated catch block
            e.printStackTrace();
           }
    }

  public static synchronized Emf getInstance() {
      if (theInstance == null) {
        theInstance = new Emf();
     }
      return theInstance;
   }

  public EntityManagerFactory getFactory() {
  return entityManagerFactory;
}