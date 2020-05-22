@ControllerAdvice
public class CentralizedExceptionHandler {

    @ExceptionHandler(IllegalContentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleError(IllegalContentException e) {
        return "Illegal argument";
    }
}