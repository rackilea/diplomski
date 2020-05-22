public static ServiceLocator createAndPopulateServiceLocator(String name) throws MultiException {
    ServiceLocator retVal = ServiceLocatorFactory.getInstance().create(name);

    DynamicConfigurationService dcs = retVal.getService(DynamicConfigurationService.class);
    Populator populator = dcs.getPopulator();

    try {
        populator.populate();
    }
    catch (IOException e) {
        throw new MultiException(e);
    }

    return retVal;
}