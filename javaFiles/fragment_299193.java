@ExceptionHandler(value = Exception.class)
public ModelAndView redirectToErrorPage(Exception e) {
    ModelAndView mav = new ModelAndView("errorPage");
    mav.getModelMap().addAttribute("message", "error on server");
    return mav;
}