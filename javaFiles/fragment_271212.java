@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        throw new MyCustomException("I just can't say hello!");
    }
}