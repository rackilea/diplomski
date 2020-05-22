private Class<?> scanPackage(String source) {
    while (!source.isEmpty()) {
        val components = this.scanner.findCandidateComponents(source);
        val testConfig = System.getProperties();
        val testConfigFile = "test-config.properties";
        val applicationClassConfigKey = "main.application.class";
        try {
            testConfig.load(this.getClass().getResourceAsStream("/" + testConfigFile));
        } catch (IOException e) {
            logger.error("Error reading configuration file: {}, using default algorithm", testConfigFile);
        }
        if (testConfig.containsKey(applicationClassConfigKey)) {
            if (!components.isEmpty() && testConfig.containsKey(applicationClassConfigKey) && testConfig.getProperty(applicationClassConfigKey) != null) {
                boolean found = false;
                val configClassName = testConfig.getProperty(applicationClassConfigKey);
                for (BeanDefinition component: components) {
                    if (configClassName.equals(component.getBeanClassName())) {
                        found = true;
                        break;
                    }
                }
                Assert.state(found,
                    () -> "Found multiple @SpringBootConfiguration annotated classes "
                        + components + ", none of which are of type " + configClassName);
                return ClassUtils.resolveClassName(
                    configClassName, null);
            }
        } else {
            if (!components.isEmpty()) {
                Assert.state(components.size() == 1,
                    () -> "Found multiple @SpringBootConfiguration annotated classes "
                                    + components);
                return ClassUtils.resolveClassName(
                     components.iterator().next().getBeanClassName(), null);
            }
        }
        source = getParentPackage(source);
    }
    return null;
}