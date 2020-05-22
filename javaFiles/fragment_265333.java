@RestController
@RequestMapping("/user")
public class UserController {

@GetMapping("/add")
public SampleObj getJson() {
    return new SampleObj();
 }
}