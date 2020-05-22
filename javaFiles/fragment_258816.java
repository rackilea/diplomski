@RequestMapping(value = "/search", method = RequestMethod.GET)
public String showEventsByName(@RequestParam (value = "search", required = false) String name, Model model) {
    if(name!=null && !name.isEmpty()){
       model.addAttribute("searchResult", eventService.searchForName(name));
    } // else{ } create an empty list or handle null in view
    // ...
}