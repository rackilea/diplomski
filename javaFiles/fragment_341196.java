@RestController
public class HomeController {

    @PostMapping("/")
    public String index(@RequestBody User user,HttpSession httpSession) {

    if(authenticateJndi(user.getUsername(),user.getPassword()))
   {

   // Login success 

   httpSession.setAttribute("userName",user.getUsername()),;

   }

  else 
    {

   // Login failed 

    }

    }
}