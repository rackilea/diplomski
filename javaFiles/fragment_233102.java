@RestController
public class GreetingController {

    private final Counter counter;

    public GreetingController(Counter c) {
        this.counter = c;
    }

    @RequestMapping("/count")
    public ResponseEntity greeting() {
        return ResponseEntity.ok(counter.getNext());
    }
}