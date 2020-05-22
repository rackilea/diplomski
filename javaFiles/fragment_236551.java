@ExceptionHandler(DataAccessException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public String handleDataAccessException(DataAccessException ex) {
    // Do some stuff
    return "errorView";
}