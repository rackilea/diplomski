@WebListener
public class ContextListenerExample implements ServletContextListener {
    public void contextInitialized(ServletContextEvent e){
        System.setProperty("org.jboss.logging.provider", "slf4j");
    }
}