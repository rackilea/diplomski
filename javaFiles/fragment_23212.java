public class ApplicationModule extends AbstractModule {
  @Override protected void configure() {
    bind(UserDAO.class)       // Define UserDAO 
      .to(UserDAOImpl.class)  // as implemented by UserDAOImpl
      .in(Singleton.class);   // and make it a singleton.
  }
}