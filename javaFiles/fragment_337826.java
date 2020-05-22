package Bot;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class CarregarBot
 *
 */

public class CarregarBot implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("CarregarBot initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

}