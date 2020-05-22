@Controller
public class IndexController {

    @RequestMapping("/index.htm")
    public String handleIndexGet() {
        return "index"; // forward to view index.jsp
    }

}