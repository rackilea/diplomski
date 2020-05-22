import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    private ObjectName objectName;

    public void contextInitialized(final ServletContextEvent sce) {
        System.out.println("---> bean context listener started");

        final MBeanServer mbeanServer = 
            ManagementFactory.getPlatformMBeanServer();
        try {
            final InitialContext initialContext = new InitialContext();
            final Context envContext = 
                (Context) initialContext.lookup("java:/comp/env");

            objectName = new ObjectName("com.example:type=Hello");
            final Hello helloMbean = new Hello(envContext);
            mbeanServer.registerMBean(helloMbean, objectName);
            System.out.println("---> registerMBean ok");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(final ServletContextEvent sce) {
        System.out.println("---> bean context listener destroyed");
        final MBeanServer mbeanServer = 
            ManagementFactory.getPlatformMBeanServer();
        try {
            mbeanServer.unregisterMBean(objectName);
            System.out.println("---> unregisterMBean ok");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}