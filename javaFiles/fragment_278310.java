@RequestMapping(value="/{site}/blah/blah", method=RequestMethod.GET)
public ModelAndView blahBlah(HttpServletRequest req,
                             HttpServletResponse resp,
                             @PathVariable("site") String site) {
   // do stuff here
}