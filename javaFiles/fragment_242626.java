@Controller
public class ErrorsController {

    @RequestMapping("/403")
    public void forbidden(HttpServletRequest request, HttpServletResponse response) {
       response.setStatus(HttpServletResponse.SC_FORBIDDEN);
       response.getWritter().write("You do not have permission to perform this operation");
    }
}