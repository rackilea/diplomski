@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {UnauthorizedException.class})
    public ResponseEntity<Object> handleException(UnauthorizedException ex){
        return new ResponseEntity<Object>(
      ex.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

}