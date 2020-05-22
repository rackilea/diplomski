@RestController
public class Gateway
{

@RequestMapping(value = {"/error"}, method = RequestMethod.GET)
public String error() {

    return "Error";
}
@RequestMapping(value = {"/api/home"}, method = RequestMethod.GET , produces = "application/json")
public Message homePage() {
    Message message = new Message(1 , "test" , "this is a test");
    return message;
}
@RequestMapping(value = {"/api/test"}, method = RequestMethod.GET )
public Message test() {
    //Message message = new Message(1 , "test" , "this is a test");
    CustomMessage customMessage = new CustomMessage();
    customMessage.setS1("tests1");
    customMessage.setS2("test s2");
    customMessage.setSubject("test");
    return customMessage;
}

@RequestMapping(value = "/login", method = RequestMethod.GET)
public String loginPage(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

    if (error != null) {
        return "login?error";
    }

    if (logout != null) {
        return "login?logout";
    }
    return "ok";
}
}