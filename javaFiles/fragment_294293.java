@ControllerAdvice
@EnableWebMvc
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception exception){
        ModelAndView andView = new ModelAndView();
        andView.addObject("exception",exception);
        andView.setViewName("/common/error");
        return andView;
    }
}