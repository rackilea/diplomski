@Controller
public class MyController {

    @GetMapping(...)
    public ResponseEntity<List<User>> testErrors(...) {
        throw new MyException();
    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity<?> handleMyException() {
        ...
    }

}