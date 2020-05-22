private final ObjectMapper objectMapper = new ObjectMapper();

@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
public ResponseEntity<byte[]> requestMethodNotSupported(HttpMediaTypeNotAcceptableException e) {
    Object response = ...;
    try {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(objectMapper.writeValueAsBytes(response));
    } catch (Exception subException) {
        // Should never happen!!!
        subException.addSuppressed(e);
        throw subException;
    }
}