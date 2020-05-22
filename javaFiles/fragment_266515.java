import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class QuartzTimerListener implements ServletContextListener{

@Override
public void contextInitialized(ServletContextEvent arg0) {
            ...
            // Start Quartz timer here
            ...
}

@Override
public void contextDestroyed(ServletContextEvent arg0) {
            ...
            // Clean up Quartz timer
            ...
}
}