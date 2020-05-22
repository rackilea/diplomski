@WebListener
public class ExecutorListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        Executor executor = Executors.newFixedThreadPool(10);
        sce.getServletContext().setAttribute("executor", executor);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // add executor fancy shutdown logic here
    }
}