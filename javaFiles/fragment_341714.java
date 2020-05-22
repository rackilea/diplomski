import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//Place your Imports Appropriately

/**
 * @author Praveen
 *
 */
  @EnableWebMvc
  @EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
  @ImportResource({ "classpath:main-servlet.xml"})
  @ComponentScan
  public class FakeAppBooter {
  private ApplicationContext ctx;
  public static void main(String[] args) {
  SpringApplication.run(FakeAppBooter.class, args);
  System.out.println("Test>>>>");
 }
  public DispatcherServlet mvcDispatcherServlet() {
     ctx = new ClassPathXmlApplicationContext();
     ((AbstractRefreshableConfigApplicationContext)                       ctx).setConfigLocation("classpath:main-servlet.xml");
     DispatcherServlet dispatcherServlet = new DispatcherServlet();
      return dispatcherServlet;
   }

  @Bean
    public ServletRegistrationBean mvcServletRegistrationBean() {
    ServletRegistrationBean bean = new ServletRegistrationBean();
    bean.setServlet(mvcDispatcherServlet());
    ArrayList<String> list = new ArrayList<>();
    list.add("/");
    bean.setUrlMappings(list); 
    return bean;
    }
  }