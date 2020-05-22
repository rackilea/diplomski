public class Foo implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext ctx) 
             throws BeansException {
        // you won't find any reference to this setter; 
        // ...it is invoked at runtime by the Spring framework

    }

}