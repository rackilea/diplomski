@ControllerAdvice
public class GlobalExceptionHandlerController {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerController.class);

    @ExceptionHandler(UsernameNotFoundException.class)
    public @ResponseBody
    ResponseEntity usernameNotFound(UsernameNotFoundException e) {
        log.info(e.getMessage());
        return new ErrorResponseEntity(HttpStatus.FORBIDDEN, e);
    }

    @ExceptionHandler(AuthenticationException.class)
    public @ResponseBody
    ResponseEntity wrongAuthentication(AuthenticationException e) {
        log.info(e.getMessage());
        return new ErrorResponseEntity(HttpStatus.FORBIDDEN, e);
    }
}