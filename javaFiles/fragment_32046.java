@ExceptionHandler(value = { Exception.class })
protected ResponseEntity<Object> handleUncaughtException(Exception ex, WebRequest request) {

  String message = "Something bad happened";

  return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
}