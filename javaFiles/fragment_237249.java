@ControllerAdvice
    public class GlobalExceptionHandler{
        @ExceptionHandler(MyCustomException.class)
        @ResponseBody
        public ResponseEntity<?> handleCustomException(MyCustomException e) {        
            String bodyJson = "Fatal Exception while performing.";
            return ResponseEntity.status(HttpStatus.FORBIDDEN).contentType(MediaType.APPLICATION_JSON).body(bodyJson);
        }
    }