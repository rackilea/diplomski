@ExceptionHandler(Exception.class)
      public ModelAndView handleMyException(Exception  exception) {
         ModelAndView mv = new ModelAndView("redirect:errorMessage?error="+exception.getMessage());
         return mv;
              } 

  @RequestMapping(value="/errorMessage", method=RequestMethod.GET)
  public ModelAndView handleMyExceptionOnRedirect(@RequestParamter("error") String error) {
      ModelAndView mv = new ModelAndView("uncaughtException");
      mv.addObject("error", error);
      return mv;
       }