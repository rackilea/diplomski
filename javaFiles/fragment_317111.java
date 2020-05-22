@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(value = HttpStatus.PAYLOAD_TOO_LARGE)
    @ExceptionHandler(MultipartException.class)
    public void handleMultipart(MultipartException exception) {
        // to do
    }
}