@Override
public void processContextConfiguration(
        final ContextConfigurationAttributes configAttributes) {

    Assert.notNull(configAttributes, "configAttributes must not be null");
    Assert.isTrue(!(configAttributes.hasLocations() && configAttributes.hasClasses()), String.format(
        "Cannot process locations AND classes for context "
                + "configuration %s; configure one or the other, but not both.", configAttributes));