import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SomeClass {
  public static void main(String args[]) {

    // first, we create empty context ourselves
    ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext();

    // then we get its bean factory to be able to register stuff
    ConfigurableListableBeanFactory beanFactory = ctx.getBeanFactory();

    // register our bean
    YourBean beanToRegister = new YourBean();
    beanFactory.registerSingleton(beanToRegister.getClass().getCanonicalName(), beanToRegister);

    ctx.refresh(); // context refresh actually updates the status

    // here we can test a bean was actually created and working
    YourBean helloWorld = ctx.getBean(YourBean.class);
    helloWorld.setAuthor("Hello World!");
    System.out.println(helloWorld.getAuthor());
  }
}