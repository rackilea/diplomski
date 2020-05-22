@RestController("/hello")
public class HelloService {

    @GetMapping
    public String get()
    {
        return "Hello there!";
    }

}