@RequestMapping(method = RequestMethod.GET)
public String home(ModelMap modelMap, HttpServletRequest request) {

    Map<String,Object> mySurveys = getMySurveys();
    modelMap.addAttribute("surveys", mySurveys.values());
    return "home";
}