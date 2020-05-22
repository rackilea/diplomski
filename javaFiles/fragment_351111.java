@ControllerAdvice(annotations = RestController.class)
public class WebExceptionHandler extends ResponseEntityExceptionHandler
{
/**
 * This function handles the exceptions.
 *
 * @param e the thrown exception
 *
 * @return error message as XML-document
 */
@ExceptionHandler (Exception.class)
public ResponseEntity<Object> handleErrorResponse(Exception e)
{
    logger.trace("Catching Exception in REST API.", e);

    return handleExceptionInternal(e, null, null, null, null);
}

@Override
protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                         Object body,
                                                         HttpHeaders headers,
                                                         HttpStatus status,
                                                         WebRequest request)
{
    logger.trace("Catching Spring Exception in REST API.");
    logger.debug("Using " + getClass().getSimpleName() + " for exception handling.");

    // fatal, should not happen
    if(ex == null) throw new NullPointerException("empty exception");

    // set defaults
    String title = "API Error";
    String msg   = ex.getMessage();

    if(status == null) status = HttpStatus.BAD_REQUEST;

    // build response body
    WebErrorResponse response = new WebErrorResponse();

    response.type = ex.getClass().getSimpleName();
    response.title = title;
    response.message = msg;
    response.code = status.value();

    // build response headers
    if(headers == null) headers = new HttpHeaders();

    try {
        headers.setContentType(getContentType(request));
    }
    catch(NullPointerException e)
    {
        // ignore (empty headers will result in default)
    }
    catch(IllegalArgumentException e)
    {
        // return only status code
        return new ResponseEntity<>(status);
    }

    return new ResponseEntity<>(response, headers, status);
}

/**
 * Checks the given request and returns the matching response content type
 * or throws an exceptions if the requested content type could not be delivered.
 *
 * @param request current request
 *
 * @return response content type matching the request
 *
 * @throws NullPointerException     if the request does not an accept header field
 * @throws IllegalArgumentException if the requested content type is not supported
 */
private static MediaType getContentType(WebRequest request) throws NullPointerException, IllegalArgumentException
{
    String accepts = request.getHeader(HttpHeaders.ACCEPT);

    if(accepts==null) throw new NullPointerException();

    // XML
    if(accepts.contains(MediaType.APPLICATION_XML_VALUE) ||
       accepts.contains(MediaType.TEXT_XML_VALUE) ||
       accepts.contains(MediaType.APPLICATION_XHTML_XML_VALUE))
        return MediaType.APPLICATION_XML;
    // JSON
    else if(accepts.contains(MediaType.APPLICATION_JSON_VALUE))
        return MediaType.APPLICATION_JSON_UTF8;
    // other
    else throw new IllegalArgumentException();
}
}