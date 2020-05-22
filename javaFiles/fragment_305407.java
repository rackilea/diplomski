@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {    
        // do your processing
         ...
        // go on (or no) executing the logic defined in the base class 
        return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
    }
}