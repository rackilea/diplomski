@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        // ex.getCause().getCause().getClass() gives MyOwnWrittenException
        // the actual logic that handles the exception...
    }
}