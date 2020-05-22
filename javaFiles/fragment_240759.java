@ControllerAdvice
public class SampleControllerAdvice {

     @ExceptionHandler(ServiceException.class)
     public ResponseEntity<YourResponse> handleServiceException(ServiceException e) {
         // YourResponse could be any serializable type (including ServiceException)
         YourResponse body = ...
         // Set the desired HTTP response headers
         HttpHeaders responseHeaders = ...
         // Set the desired HTTP response status
         HttpStatus status = ...
         return new ResponseEntity<YourResponse>(body, headers, status);
     }

}