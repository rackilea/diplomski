@RestController
@ConditionalOnProperty(prefix="properties",name = "enabled")
public class Controller{
  public String getSomething() {
   return "Something";
  }
}