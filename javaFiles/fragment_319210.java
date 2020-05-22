@ControllerAdvice
public class RestExceptionHandler { 

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptionMethod(Exception ex, WebRequest requset) {

    ExceptionMessage exceptionMessageObj = new ExceptionMessage();

    // Handle All Field Validation Errors
    if(ex instanceof MethodArgumentNotValidException) {
        StringBuilder sb = new StringBuilder(); 
        List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
        for(FieldError fieldError: fieldErrors){
            sb.append(fieldError.getDefaultMessage());
            sb.append(";");
        }
        exceptionMessageObj.setMessage(sb.toString());
    }else{
        exceptionMessageObj.setMessage(ex.getLocalizedMessage());
    }

    exceptionMessageObj.setError(ex.getClass().getCanonicalName());
    exceptionMessageObj.setPath(((ServletWebRequest) requset).getRequest().getServletPath());

    // return exceptionMessageObj;
    return new ResponseEntity<>(exceptionMessageObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}