@ExceptionHandler(UserException.class)
public ModelAndView handleUserException(UserException e) {
    ModelAndView modelAndView = new ModelAndView("viewName");
    modelAndView.addObject("errorMessage", e.getMessage());
    return modelAndView;
}