public class GuiceFeature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        // This is the way in Jersey 2.26+ to get the ServiceLocator.
        // In earlier versions, use
        // ServiceLocatorProvider.getServiceLocator(context);
        ServiceLocator locator = InjectionManagerProvider.getInjectionManager(context)
                .getInstance(ServiceLocator.class);

        Injector injector = Guice.createInjector(new AccountResourceModule());
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(locator);
        GuiceIntoHK2Bridge guiceBridge = locator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(injector);
        return true;
    }
}