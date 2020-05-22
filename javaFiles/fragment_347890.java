@WebListener
public class Banner implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(System.getenv());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}