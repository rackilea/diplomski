@Controller
public class ... {

   @GetMapping(value = ..., produces ...)
   //no request body, void return type, response will be autowired and can be handled
   public void generatePdf(javax.servlet.http.HttpServletResponse response) throws ... {
      java.io.OutputStream outStr = response.getOutputStream();
      // dump from "somewhere" into outStr, "finally" close.
      outStr.close();
      //TO BE TESTED:
      response.sendRedirect("/");
   }
}