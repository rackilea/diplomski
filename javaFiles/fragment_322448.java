public class JerseyApplication extends ResourceConfig {

    @Inject
    public JerseyApplication(ServiceLocator locator) {
        ServiceLocatorUtilities.enableImmediateScope(locator);
    }
}