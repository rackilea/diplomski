@Controller
public class MyController {

    @RequestMapping("/myurl")
    @ResponseBody
    public String myMethod() {
        return "myResponse";
    }

}