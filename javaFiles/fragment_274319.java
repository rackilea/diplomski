@RequestMapping("details")
public ModelAndView helloDetails(HttpServletRequest request) {
    final ModelAndView mav = new ModelAndView("details");
    mav.addObject("address", getParameter("address"));
    return mav;
}


@RequestMapping("list")
public ModelAndView helloList() {
    final ModelAndView mav = new ModelAndView("list");
    return mav;
}