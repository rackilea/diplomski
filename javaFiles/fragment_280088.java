@RestControllerAdvice
public class ExampleControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorMsg("Server error " + e); // or whatever you want
        response.setErrorCode("ERROR007"); // or whatever you want
        request.removeAttribute(
                  HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE);

        return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}