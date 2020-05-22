public class LoggingServletContextListener
           implements ServletContextListener {

  private static final Logger logger = LogManager.getLogger(LoggingServletContextListener.class);

  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }

  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    logger.info(System.getProperties());      
  }
}