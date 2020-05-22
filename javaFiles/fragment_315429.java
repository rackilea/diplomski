@ControllerAdvice
public class GlobalExceptionController {
    @Resource(name = "staticDatabaseManager")
    private StaticDB db;

    @ExceptionHandler(SessionAuthenticationException.class)
    @ResponseStatus(value=HttpStatus.FORBIDDEN, reason="session has expired") //403
    public ModelAndView expiredException(HttpServletRequest request, Exception e) {
        ModelAndView mav = new ModelAndView("exception");
        mav.addObject("name", e.getClass().getSimpleName());
        mav.addObject("message", e.getMessage());
        return mav;
    }

    @ExceptionHandler({UnexpectedRollbackException.class, 
                       EntityExistsException.class,
                       OptimisticLockException.class,
                       PersistenceException.class})
    @ResponseStatus(value=HttpStatus.CONFLICT, reason="conflicting requests") //409
    public ModelAndView conflictException(HttpServletRequest request, Exception e) {
        ModelAndView mav = new ModelAndView("exception");
        mav.addObject("name", e.getClass().getSimpleName());
        mav.addObject("message", e.getMessage());

        synchronized (db) {
            db.setUserInfo(request);
            db.log("Conflicting "+request.getMethod()+" request to "+request.getRequestURI()+" ("+e.getClass().getSimpleName()+").", Log.LVL_SECURITY);
        }        

        return mav;
    }

    //ResponseEntity<String> customHandler(Exception ex) {
    //    return new ResponseEntity<String>("Conflicting requests, try again.", HttpStatus.CONFLICT);
    //}
}