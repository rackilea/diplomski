import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("Application started");  
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }
}