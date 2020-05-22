@RequestMapping(value = "/dosomething", method = RequestMethod.GET)
public ModelAndView dosomething(HttpServletRequest request, HttpServletResponse response)  throws IOException {
    // setup your Cookie here
    response.setCookie(cookie)
    ModelAndView mav = new ModelAndView();
    mav.setViewName("redirect:/other-page");

    return mav;
}