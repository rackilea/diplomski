public ModelAndView getSomeTest(HttpServletRequest request, HttpServletResponse response){
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("view", "pathToMyXHTMLFile/someTest");
    map.put("name", "tomik");

    ModelAndView returnModelAndView = new ModelAndView("ajaxJsf_increaseLimit", map);

    return returnModelAndView;
}