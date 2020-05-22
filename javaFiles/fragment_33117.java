package app.classes;

    import javax.servlet.ServletContextEvent;
    import javax.servlet.ServletContextListener;
    import javax.servlet.annotation.WebListener;


    /**
     * Application Lifecycle Listener implementation class ContextListenerProcess
     *
     */
    @WebListener
    public class ContextListenerProcess implements ServletContextListener {

        /**
         * Default constructor. 
         */
        public ContextListenerProcess() {
            // TODO Auto-generated constructor stub
        }

        public void contextDestroyed(ServletContextEvent sce) {
        }

        public void contextInitialized(ServletContextEvent sce) {
            // Do your startup work here
            System.out.println("Processing Started .....");
        }
    }