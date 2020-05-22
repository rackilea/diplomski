@RequestMapping
public ModelAndView renderFooList() {
    ModelAndView mav = new ModelAndView("foo/list");
    mav.addObject("foos", fooService.getFoos());
    return mav;
}