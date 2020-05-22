@Controller
public class MyController {

   @RequestMapping(value="/myMapping")
   public R myMethod(HttpServletRequest request, ...) {

      //Get the servletcontext from request
      InputStream input = request.getSession().getServletContext().
             getResourceAsStream("/WEB-INF/db.properties");

     //read properties

   }   
}