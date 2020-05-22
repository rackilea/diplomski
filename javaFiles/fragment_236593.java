@RestController
public class YourRestController {
    @RequestMapping(value="/your/endpoint", method=RequestMethod.POST)
    public ResponseEntity<String> someMethod(@RequestBody YourDTO data) {
        // business logic here
    }
}