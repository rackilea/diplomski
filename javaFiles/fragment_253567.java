@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionControllerAdvice {

    private MessageSource messageSource;

    public ExceptionControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler({DocumentAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public cat.gencat.ctti.canigo.arch.web.rs.model.Error handleException( DocumentAlreadyExistsException e) {

        cat.gencat.ctti.canigo.arch.web.rs.model.Error error = new cat.gencat.ctti.canigo.arch.web.rs.model.Error();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(messageSource.getMessage(e.getLocalizedMessage(), null, null));
        return error;
    }
}