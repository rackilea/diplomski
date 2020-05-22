@ControllerAdvice
public class BaseAdvisedController {

    @ExceptionHandler({RootContextRepositoryException.class})
    public String rootContextRepositoryExceptionHandler(RootContextRepositoryException ex){
        return "index.html";
    }

}