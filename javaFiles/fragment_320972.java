@RestController

@RequestMapping("/common")
public class MethodNameController {
    public String test() {
        return "test";
    }
    public String test2() {
        return "test2";
    }
}