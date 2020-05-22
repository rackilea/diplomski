@RestController
public class myController {

    ...

    @Autowired  // <-- Forgot this annotation.
    private RestTemplate restTemplate;

    ...

}