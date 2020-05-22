@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid Inputs")
    @ExceptionHandler(CustomException.class)
    private void errorHanlder() {
        //Log exception
    }


  public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
    Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
    Throwable error = getError(requestAttributes);
    if (error instanceof CustomException) {
        errorAttributes.put("errorList", ((CustomException)error).getErrors());
    }
    return errorAttributes;
}