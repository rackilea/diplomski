@Configuration
public class YourConfiguration {

  @Bean(name="concreteBean")
  @Conditional(YourCondition.class)
  public YourInterface concreteBean(){
      return new ConcreteBean();
  }

  @Bean(name="noopBean")
  @Conditional(YourCondition.class)
  public YourInterface noopBean(){
    return new NoopBean();
  }

}