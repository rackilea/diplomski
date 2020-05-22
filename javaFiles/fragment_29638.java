...
import AppPropertiesBundle;

@SpringBootApplication
public class DemoApp
{

   public static void main(String[] args)
   {
      ConfigurableApplicationContext context = SpringApplication.run(DemoApp.class, args);

      AppPropertiesBundle.A propsA = context.getBean(AppPropertiesBundle.A.class);
      System.out.println("a.property1=" + propsA.getProperty1());
      System.out.println("a.property2=" + propsA.getProperty2());

      AppPropertiesBundle.B propsB = context.getBean(AppPropertiesBundle.B.class);
      System.out.println("b.property1=" + propsB.getProperty1());
      System.out.println("b.property2=" + propsB.getProperty2());

      context.close();
   }

}