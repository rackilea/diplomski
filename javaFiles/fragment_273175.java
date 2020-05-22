@Controller
public class YourCustomController implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping(value = PATH, produces={"text/html"})
    public String error() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}