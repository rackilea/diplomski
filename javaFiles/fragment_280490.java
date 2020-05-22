@Configuration
public class MyConfig {

  @Bean
  public MyBean myBean() {
    MyBean bean = new MyBean();
    bean.setName("...");
    bean.setAttribute("...");
    return bean;
  }
}