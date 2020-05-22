@RestController
 public class RestartController {
 @RequestMapping(value = "/restart-admin", method = RequestMethod.POST)
    public void restart() {    
        org.springframework.boot.devtools.restart.Restarter.getInstance().restart();
    }

}