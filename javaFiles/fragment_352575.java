@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyException.class)
    public ResponseEntity<?> handleMyException() {
        ...
    }

}

@Controller
public class MyController {

    @GetMapping(...)
    public ResponseEntity<List<User>> testErrors(...) {
        throw new MyException();
    }

}