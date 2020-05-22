@ControllerAdvice
public class MyExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(Exeption.class)
  public ModelAndView handleFileNotFoundException(Exception exception){

    ModelAndView modelAndView = new ModelAndView();

    modelAndView.setViewName("yourView");
    modelAndView.addObject("exception", exception);

    return modelAndView;
 }

}