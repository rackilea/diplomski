public class MyContextListener 
           implements ServletContextListener{

  @Override
  public void contextDestroyed(ServletContextEvent arg0) {
    //do stuff
  }

  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    //do stuff before web application is started
  }
}