/**
* REST exception handlers defined at a global level for the application
**/
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { PersonalException.class })
    protected ResponseEntity<RestResponse> handleUnknownException(PersonalException ex, WebRequest request) {
       LOGGER.error(ex.getMessage(), ex);

       return new ResponseEntity<RestResponse>(new RestResponse(Boolean.FALSE, ImmutableList.of("Exception message"), null), HttpStatus.INTERNAL_SERVER_ERROR);
     }