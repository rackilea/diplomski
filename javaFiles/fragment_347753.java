@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
@ExceptionHandler({ Exception.class })
public String handleGeneralException(final Exception e) {
    logException("General Exception : ", e);
    return e.toString();
}