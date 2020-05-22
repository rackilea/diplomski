public class MyContextListener extends BaseTask implements ServletContextListener {

    private final Logger logger = LogManager.getLogger(getClass());

    @Override
    public void contextInitialized(ServletContextEvent event) {
        logger.warn("Start");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        logger.warn("End" + appContext);
        WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext()).getBean("myBean");
    }

}