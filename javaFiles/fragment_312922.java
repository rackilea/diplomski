@Scope("session")
     @Controller
     public class UserController {
     @RequestMapping(method = RequestMethod.GET)
     public String testMestod(HttpServletRequest request){
     User user=(User)session.getAttribute("cart");
     return "testJsp";
     }
   }