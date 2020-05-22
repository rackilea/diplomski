@WebListener
    public class MyProjectListener implements ServletContextListener {

        @Override
        public void contextInitialized(ServletContextEvent sce) {
            //add your file creation code here
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            //add code cleanup the resources
        }
    }