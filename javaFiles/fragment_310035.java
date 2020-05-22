@Controller
public class ErrorController {
      @RequestMapping(value="/error")
      public String handlePageNotFoundException(Exception ex,
          HttpServletResponse response) {
     return "error";
      }

}