public class SpringContextHolder implements ApplicationContextAware {

   private static ApplicationContext applicationContext = null;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         this.applicationContext = applicationContext;
    }
    public void init(){

        ServiceBean1 srv1 = (ServiceBean1)applicationContext.getBean("serviceBean1");

        myNonSpringObject.setService1(srv1); // Or something
    }
}