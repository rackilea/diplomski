@RequestMapping(method=RequestMethod.GET, value="/pdf")
public ModelAndView showPDF(ModelMap model, HttpServletRequest request) {
    Result result = (Result)request.getSession().getAttribute("result");
    model.addAttribute("result", result);
    return new ModelAndView("PDF", model);
}