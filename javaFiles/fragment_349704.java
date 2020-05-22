@RestController
public class DemoController {

@Autowired
UserRepository userRepository;

@GetMapping("/save")
public User doSave() {
    Map<String, Object> attributes = new HashMap<>();

    attributes.put("time", Instant.now());
    attributes.put("num", 5.6);
    attributes.put("str", "5.6");

    return userRepository.save(new User(attributes));
}
}