@RestController
@RequestMapping("/add")
public class HomeController {

    @GetMapping(value = "/hello") 
    public String add() {
        return "Hello";
    }
}