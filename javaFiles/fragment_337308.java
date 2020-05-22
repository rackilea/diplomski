import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzServletContextListener implements ServletContextListener
{
    public static final String QUARTZ_FACTORY_KEY = "org.quartz.impl.StdSchedulerFactory.KEY";
    private StdSchedulerFactory factory = null;

    /**
     * Called when the container is shutting down.
     */
    public void contextDestroyed(ServletContextEvent sce)
    {
        try
        {
            factory.getDefaultScheduler().shutdown();
        } catch (SchedulerException ex)
        {
        }

    }

    /**
     * Called when the container is first started.
     */
    public void contextInitialized(ServletContextEvent sce)
    {
        ServletContext ctx = sce.getServletContext();
        try
        {
            factory = new StdSchedulerFactory();

            // Start the scheduler now
            factory.getScheduler().start();
            ctx.setAttribute(QUARTZ_FACTORY_KEY, factory);

        } catch (Exception ex)
        {
        }
    }
}