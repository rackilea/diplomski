import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ni.apps.engineering.certification.controller.AbstractFacade;

public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        AbstractFacade.closeFactory();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {

    }

}