@ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ValidationErrorDTO> processValidationIllegalError(HttpMessageNotReadableException ex,
            HandlerMethod handlerMethod, WebRequest webRequest) {

        Throwable throwable = ex.getMostSpecificCause();
        ValidationErrorDTO errorDTO = new ValidationErrorDTO();
        if (throwable instanceof EnumValidationException) {

            EnumValidationException exception = (EnumValidationException) ex.getMostSpecificCause();

            errorDTO.setEnumName(exception.getEnumName());
            errorDTO.setEnumValue(exception.getEnumValue());
            errorDTO.setErrorMessage(exception.getEnumValue() + " is an invalid " + exception.getEnumName());
        }

        return new ResponseEntity<ValidationErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
    }