public class ServiceManager {

ApplicationContext appContext;
String APP_HOME = System.getProperty("user.home") + File.separator;

public void init() {
    //set main spring context
    appContext = new AnnotationConfigApplicationContext(AppConfig.class);
}

public void start(String serviceName) throws Exception {
    ApplicationContext serviceContext = new FileSystemXmlApplicationContext(
            new String[]{APP_HOME + serviceName + ".xml"}, //path to child ctx
            appContext); //reference to parent ctx to build hierarchy
    Service service = (Service) serviceContext.getBean("service");
    service.start();
}