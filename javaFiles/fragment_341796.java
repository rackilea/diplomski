@ExceptionHandler(DocumentNotFoundException.class)
public ResponseEntity<?> handleException(DocumentNotFoundException e) {

    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body("{\"error\": \"Invoice not found\"}");
}