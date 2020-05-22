@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);


@ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
public void handleException(HttpServletResponse response, Exception ex) {
    //build your custom message
    prepareErrorResponse(response,UNPROCESSABLE_ENTITY,yourCustomMessage);
}



private void prepareErrorResponse(HttpServletResponse response, HttpStatus status, String apiError) {
    response.setStatus(status.value());
    try(PrintWriter writer = response.getWriter()) {
        new ObjectMapper().writeValue(writer, apiError);
    } catch (IOException ex) {
        logger.error("Error writing string to response body", ex);
    }
}