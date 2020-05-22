public class QuartzContextListener implements ServletContextListener {

    @Inject
    private static Provider<DataAccess> dataAccessProvider;

    ...
}