@ExceptionHandler(DataAccessException.class)
        public Object handleError(HttpServletRequest req, DataAccessException ex) {
    logger.error("Request: " + req.getRequestURL() + " raised " + ex);
if("XMLHttpRequest".equals(request.getHeader("X-Requested-With")))
        {       
        ResponseEntity<String> dataExceptionRes=null;
dataExceptionRes=new ResponseEntity<String>(HttpStatus.FORBIDDEN);
return dataExceptionRes;
}
else{
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", ex);
    mav.addObject("url", req.getRequestURL());
    mav.setViewName("error");
    return mav;
}
  }