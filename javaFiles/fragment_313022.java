@RestControllerAdvice
public class ExampleRestControllerAdvice {

@ExceptionHandler(value = SomeException.class)
public ResponseEntity<ErrorResponse> handleSomeException(SomeException e) {

    ErrorResponse response = new ErrorResponse();
    response.setErrorMsg(e.getErrorMsg());
    response.setErrorCode(e.getErrorCode().getCode());

    return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(value = Exception.class)
public ResponseEntity<ErrorResponse> handleException(Exception e) {

    ErrorResponse response = new ErrorResponse();
    response.setErrorMsg("Server error");
    response.setErrorCode("ERR007");

    return new ResponseEntity<ErrorResponse>(response,
            HttpStatus.INTERNAL_SERVER_ERROR);
}

}