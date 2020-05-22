@CrossOrigin
@RestController
@RequestMapping("/api")
class HelloController {

    @GetMapping("/hello")
    public HelloMessage hello() {
        return new HelloMessage("Hello World!")
    }
}