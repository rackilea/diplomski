@RequestMapping(value = "/simple_handler", method = RequestMethod.GET)
 @ResponseBody
 public void simpleHandler(HttpServletRequest request, ModelMap model){
     this.carryOutSomeTask();
     return "Done";
 }