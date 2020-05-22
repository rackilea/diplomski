@ExceptionHandler(InvalidParameterException.class)
@ResponseBody
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public ErrorMessageDTO handleInvalidParameter(InvalidParameterException ex) {
    // Write your own DTO to return an exception
    return new ErrorMessageDTO(ex.getMessage());
}