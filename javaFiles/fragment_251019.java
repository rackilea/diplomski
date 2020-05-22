public class ContextInitialize implements ServletContextListener {
  private static Properties props;
  public void contextInitialized(ServletContextEvent servletContextEvent) {
     // connect to DB
     // Load all the key values pairs as required
     //put this into a Properties object, or create a hashtable, hashmap ..
  }
  //Getter
  public String getProperty(String key){
     // get value of key
  }
  //Setter
  public void setProperty(String key, String value){
     // set value to a key
  }
}