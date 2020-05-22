@RestController
@RequestMapping("/resources")
public class AController {

    private BService service;

    @Autowired
    public AController(BService service) {
        this.service = service;
    }

    @RequestMapping("/test")
    public ResponseEntity<String> test() {
        ResponseEntity<String> result = service.test();
        if (result.hasBody()) {
            //doSomething
        }

        return result; //or list like you did
    }
}

@Service
public class BService {

    public ResponseEntity<String> test() {
        try {
            return ResponseEntity.status(201).body(getResponse()); //this always throws exception. It's just for purpose of example
        } catch (CustomException ex) {
            return ResponseEntity.status(400).build();
        }

    }

    private String getResponse() {
        throw new CustomException("Not OK!");
    }
}