@ControllerAdvice
public class ExceptionLogAdvice {

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ResponseBody
    public ResponseEntity<Object> handleValidationException(final InternalServerException internalServerException){

        ErrorResponseDTO dto = constructErrorResponse(internalServerException);
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
    }
}