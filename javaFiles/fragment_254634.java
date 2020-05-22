@RestControllerAdvice
public class RestApiExceptionController {

    @ExceptionHandler(ValidationErrorException.class)
    public ResponseEntity<?> appNotFoundException(ValidationErrorException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ErrorResponse(exception.getErrorCode(), exception.getMessage())); 
    }
}