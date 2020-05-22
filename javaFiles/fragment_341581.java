@RequestMapping(value = "endpoint", method = RequestMethod.GET)
public void doIt(HttpServletRequest request, HttpServletResponse response) {
  if (request.getHeader("Accept").matches("application/zip"))
    doZip();
  else
    doVideo();