@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ModelAttribute("activeUserWorkgroup ")
    public String getActiveWorkgroup() {    
       //YOUR CODE
    }

}