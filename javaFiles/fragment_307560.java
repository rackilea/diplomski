@RestController
public class GreetingController {
    @RequestMapping("/itext")
    public String test(){
        System.out.println("Test");
        return "Test";
    }
}