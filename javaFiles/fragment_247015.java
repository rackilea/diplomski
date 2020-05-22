@Controller("/hello")
public class MyController {
    @Get(produces = MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}