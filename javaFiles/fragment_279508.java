@ExceptionHandler(NoHandlerFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public String handle(NoHandlerFoundException ex) {

  return "my404Page";
}