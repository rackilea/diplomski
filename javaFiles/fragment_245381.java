@Priority(0)
public class GuiceFeature implements Feature {

    private Injector i;

    public GuiceFeature(Injector i) {
        this.i = i;
    }

    @Override
    public boolean configure(FeatureContext context) {
        ServiceLocator locator = ServiceLocatorProvider.getServiceLocator(context);

        GuiceBridge.getGuiceBridge().initializeGuiceBridge(locator);
        GuiceIntoHK2Bridge guiceBridge = locator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(i);

        return true;
    }

}