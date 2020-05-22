@ControllerAdvice
public class CustomizedExceptionHandler  {

    @ExceptionHandler(NotFoundException.class) // change here for your exception.
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(NotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN); // you can return whatever you want.
    }

}