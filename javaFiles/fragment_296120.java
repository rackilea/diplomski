@Controller
public class LoginController {

    private static final String REQUEST_URL = "/login";
    private static final String VIEW = "login";

    @RequestMapping(value = REQUEST_URL, method = RequestMethod.GET)
    public String setupLogin(@RequestParam("user") String user, @RequestParam("password") String password, HttpServletRequest request) {

        // adapt 'j_username' and 'j_password' depending on the names used in your login page
        request.setAttribute("j_username", user);
        request.setAttribute("j_password", password);

        return VIEW;
    }

}