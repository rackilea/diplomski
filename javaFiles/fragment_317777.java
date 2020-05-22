@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomException customException = new CustomException(NOT_FOUND, ex.getMessage(), ex.getLocalizedMessage(), ex);
        ex.printStackTrace();
        return new ResponseEntity<>(customException, customException.getStatus());
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleSpringExceptions(HttpServletRequest request, Exception ex) {
        CustomException customException = new CustomException(INTERNAL_SERVER_ERROR, ex.getMessage(), ex.getLocalizedMessage(), ex);
        ex.printStackTrace();
        return new ResponseEntity<>(customException, customException.getStatus());

    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomException customException = new CustomException(INTERNAL_SERVER_ERROR, ex.getMessage(),ex.getLocalizedMessage(), ex);
        ex.printStackTrace();
        return new ResponseEntity<>(customException, customException.getStatus());
    }
}