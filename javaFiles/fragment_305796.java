@RequestMapping(value = "/bar", method = RequestMethod.GET)
public ModelAndView handleGet(HttpServletRequest request) {
  Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
  if (inputFlashMap != null) {
    String some = (String) inputFlashMap.get("some");
    // do the job
  }
}