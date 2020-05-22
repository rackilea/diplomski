protected String[] getInlinedProperties(MergedContextConfiguration config) {
    ArrayList<String> properties = new ArrayList<String>();
    // JMX bean names will clash if the same bean is used in multiple contexts
    disableJmx(properties);
    properties.addAll(Arrays.asList(config.getPropertySourceProperties()));
    if (!isEmbeddedWebEnvironment(config) && !hasCustomServerPort(properties)) {
        properties.add("server.port=-1");
    }
    return properties.toArray(new String[properties.size()]);
}