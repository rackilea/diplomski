@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseBody
public ValidationFailureResponse validationError(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    final List<FieldError> fieldErrors = result.getFieldErrors();

    return new ValidationFailureResponse((FieldError[])(fieldErrors.toArray(new FieldError[fieldErrors.size()])));
}