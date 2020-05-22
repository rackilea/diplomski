@RestController
public class MyController {
  @RequestMapping("/")
  public Map<String, Object> testMethod(@RequestParam("color") Color color) {
    Map<String, Object> map = new HashMap<>();
    map.put("color", color);
    return map;
  }
}