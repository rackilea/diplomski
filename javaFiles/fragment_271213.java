@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<String> handlyMyCustomException(MyCustomException e) {
        logger.error("error occurred {}", e);
        return new ResponseEntity<>("Something happened: " + e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
    }
}