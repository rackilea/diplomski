@RequestMapping(method=RequestMethod.POST)
public ModelAndView sendEmail(HttpServletResponse resp)
{
    resp.sendRedirect("/nextPageClass?booleanValueObj=true");
    return null;
}

@RequestMapping("/nextPageClass")
public class NextPageController 
{
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView nextPage(HttpServletRequest req) 
    {
        ModelAndView modelAndView = new ModelAndView("/nextPage");

        Boolean booleanValueObj = null;
        String booleanValueParam = req.getParameter("booleanValueObj");
        if (booleanValueParam != null)
             booleanValueObj = Boolean.parse(booleanValueParse);
        modelAndView.addObject("booleanValueObj", booleanValueObj);

        return modelAndView;
    }
}