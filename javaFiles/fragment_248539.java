@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/whatever")
    public String myMethod(HttpServletRequest request, HttpServletResponse response) {
        return "hello.html";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}