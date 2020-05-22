@Controller
public class Controller
{
    @RequestParam("/test.htm")
    public String action(Model model, HttpServletRequest request)
    {
        //Something
        try {
            request.getParameter("user_name"); //write in try-catch block
        } catch(ServletException ex) {
        }
    }
}