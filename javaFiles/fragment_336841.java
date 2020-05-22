@RequestMapping(value = "/updatestatus", method = RequestMethod.GET)
public ModelAndView getRequests(){
    ModelAndView mav = new ModelAndView("requests");
    //your code
    mav.addObject("STATUS", RequestStatus.APPROVED);
    return mav;
}