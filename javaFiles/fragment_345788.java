@Controller
public class ArithmeticController {
    @RequestMapping("/add")
    public String add(@RequestParam("x") int x, @RequestParam("y") int y, 
        Map<String, Object> model) {
        model.put("result", x + y);
        return "calc";
    }
}