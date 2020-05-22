@Configuration
public class MyConfig {

  @Autowired
  List<RequiredBean> requiredBeans;

  @Bean(name="customObject")
  @DependsOn({"reqBeanInsideClass", "thisOneGetsExecuted"})
  public CustomObject customObject() {
    log.info(requiredBeans.size());
  }

  @Bean(name="reqBeanInsideClass")
  public RequiredBean reqBean() {
    return new RequiredBean();
  }
}