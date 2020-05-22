@Configuration
public class CustomServletContextListener implements ServletContextListener {

    @Autowired
    private ExecutorService executorService;

    @Override
    public void contextInitialized(ServletContextEvent context) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent context) {
        executorService.shutdown();
    }

}