// should handle all exception for classes annotated with         
@ControllerAdvice(annotations = RestController.class)
@Order(1) // NOTE: order 1 here
public class RestControllerExceptionHandler {


  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleUnexpectedException(Exception e) {

    // below object should be serialized to json
    ErrorResponse errorResponse = new ErrorResponse("asdasd"); 

    return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
// should handle exceptions for all the other controllers
@ControllerAdvice(annotations = Controller.class)
@Order(2)  // NOTE: order 2 here
public class ControllerExceptionHandler {


  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleUnexpectedException(Exception e) {
    return new ResponseEntity<String>("Unexpected exception, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}