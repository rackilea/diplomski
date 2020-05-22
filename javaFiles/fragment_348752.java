@RestController
public class NowResource {
    ...

    @ExceptionHandler(IOException.class)
    public void handleException(IOException e) {
        log.warn("IOException occurred: {}", e.getMessage());
    }
}