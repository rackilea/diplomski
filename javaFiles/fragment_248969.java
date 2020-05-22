@Secured("ROLE_ADMIN")
@RestController
@RequestMapping(value = "/api")
public class MyController {

    @Autowired
    private MyService myService;

    @PostMapping(path="/run")
    public void runJobs() {
        myService.runJobs();
    }
}