@ControllerAdvice
public class ControllerHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMyException(Exception exception,
        HttpServletRequest request) {
    return "/error/myerror";
    }
}