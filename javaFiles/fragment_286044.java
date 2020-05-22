@RestController
public class MyController {

    @RequestMapping("/myurl")
    public String myMethod() {
        return "myResponse";
    }

}