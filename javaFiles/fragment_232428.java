@RestController
public class MyController {
  @RequestMapping("/")
  public MyBean get(@RequestBody MyBean myBean) {
    return myBean;
  }
}