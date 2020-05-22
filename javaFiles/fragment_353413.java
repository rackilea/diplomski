@RestController
public class Endpoint {

    @GetMapping("/error")
    public ResponseEntity createError() {

        ErrorDetails errorDetails = new ErrorDetails("some error message");
        return ResponseEntity.status(400).body(errorDetails);;
    }
}