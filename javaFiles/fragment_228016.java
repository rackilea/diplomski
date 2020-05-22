public interface RandomService{
    public boolean supports(String headerValue);
    public String doStuff();
}

@Controller
public class RandomConroller {
    @Autowired List<RandomService> services;

    public String do(@RequestHeader("someHeader") String headerValue){
        for (RandomService service: services) {
            if (service.supports(headerValue)) {
                 return service.doStuff();
            }
        }
        throw new IllegalArgumentException("No suitable implementation");
    }
}