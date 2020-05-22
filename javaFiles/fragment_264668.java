package my;

public class Listener implements javax.servlet.ServletContextListener {

   public void contextInitialized(ServletContext context) {
      MyOtherClass.callMe();
   }
}