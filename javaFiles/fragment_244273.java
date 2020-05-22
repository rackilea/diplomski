@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception ex) {
        MailService.send();
        Logger.logInSpecificWay();
        return ... custom exception 
    }
}