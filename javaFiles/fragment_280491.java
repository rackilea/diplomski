@Component
public class MyBean {

  @Value("${my.config.value}")
  private String name;

  @Value("${my.config.attribute}")
  private String attribute;

  public MyBean(){

  }
...