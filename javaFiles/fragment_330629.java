@ExceptionHandler(value = { ResponseException.class })
public ApiErrorResponse noHandlerFoundException(Exception ex) {
    LOG.error(ex.getCause().toString());
    int status = ((ResponseException) ex).getResponse().getStatusLine().getStatusCode();
    return new ApiErrorResponse(status, "<some message depending on status code>");
}