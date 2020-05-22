@Controller
public class WelcomeController {
    @RequestMapping("/home")
    public String home(HttpServletRequest request) throws Exception {

        String uri = request.getRequestURI();
        if (!isValidEndpoint(uri)) {
            throw new InvalidUrlException();
        }

        return "homePage";
    }

    private boolean isValidEndpoint(String url) {
        return url.endsWith(".html");
    }
}

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="The url needs to end with '.html'")
class InvalidUrlException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidUrlException() {
        super();
    }
}