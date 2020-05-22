@RequestMapping(value="/searchresults", method=RequestMethod.GET)
public ModelAndView searchResults(@RequestParam("searchRecord") String email, Map model) {
    ModelAndView searchResult = new ModelAndView("searchresult");
    model.put("searchresult", st.getStudent(email));
    return searchResult;
}