import org.springframework.web.bind.MethodArgumentNotValidException;

   @ExceptionHandler
    public ResponseEntity<String> handleException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<String>(HttpStatus.UNPROCESSABLE_ENTITY);

    }