CamelContext context= null;
ApplicationContext applicationContext =new FileSystemXmlApplicationContext("springconfig.xml");
JndiRegistry registry=null;
if (applicationContext != null) {
    String[] beanNames=applicationContext.getBeanDefinitionNames();
    if (beanNames != null) {
      Map<String,String> enviroment= new HashMap<String,String>();
      enviroment.put("java.naming.factory.initial", "org.apache.camel.util.jndi.CamelInitialContextFactory");
      registry= new JndiRegistry(enviroment);
      for (String name : beanNames) {
            registry.bind(name,applicationContext.getBean(name));
      }
    }
}
context= new DefaultCamelContext(registry);
InputStream is = new FileInputStream(file);
RoutesDefinition routes = context.loadRoutesDefinition(is);
context.addRouteDefinitions(routes.getRoutes());
context.start();