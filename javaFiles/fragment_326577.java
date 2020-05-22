@RestControllerAdvice
public final class ExceptionHandlerControllerAdvice {

  @ExceptionHandler({ MemberNotFoundException.class })
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ResponseEntity<ErrorDto> handleRecordNotFound(MemberNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorDto(ex.getMessage));
  }
}