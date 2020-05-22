@RequestMapping("/hello.html")
public ModelAndView processForm(HttpServlet request, HttpServletResponse response){
    //process form data etc
    ModelAndView modelAndView = new ModelAndView("redirect:hello");                
    Map<Object, Object> model = modelAndView.getModel();
    modelAndView.addObject("error", "this.is.my.error.code");
    return modelAndView;
}