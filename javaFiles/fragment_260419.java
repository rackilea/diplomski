@Controller
public class ErrorController {

     private final emailService;

     public ErrorController(MyMailService emailService) {
           this.emailService = emailService;
     } 

     // Now it is possible to send email 
     // by calling emailService.sendMail in any method
}