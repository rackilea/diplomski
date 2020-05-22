package some.package
class DatasourceRegisteringBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        HashMap<String, String> connectionsListMyDB = new HashMap<>();

        // Load your connection list from wherever you need to, you can
        // enumerate them directly from JNDI or some configuration location
        connectionsListMyDB.put("db1", "java:jboss/datasources/MYDB_ONE");
        connectionsListMyDB.put("db2", "java:jboss/datasources/MYDB_TWO");

        if (connectionsList.isEmpty())
            throw new RuntimeException("No JPA connections defined");

        // Configure the dataSource bean properties
        BeanDefinitionRegistry factory = (BeanDefinitionRegistry) beanFactory;
        MutablePropertyValues mpv = factory.getBeanDefinition("dataSourceMyDB").getPropertyValues();

        ManagedMap<String, String> mm = (ManagedMap<String, String>) mpv.getPropertyValue(
                "targetDataSources").getValue();
        mm.clear();
        for (Entry<String, String> e : connectionsListMyDB.entrySet()) {
            mm.put(e.getKey(), e.getValue());
        }
    }
}