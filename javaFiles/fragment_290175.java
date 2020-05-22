@ExceptionHandler({MethodArgumentNotValidException.class})
  public void handleMethodArgumentNotValidException(
      MethodArgumentNotValidException manve, HttpServletResponse response) throws IOException {
    exceptionLog.error(manve.getMessage());
    Map<String, String> errors =
        manve
            .getBindingResult()
            .getFieldErrors()
            .stream()
            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    String errorMessage = "...."
    if (!errors.isEmpty()) {
      ObjectMapper mapper = new ObjectMapper();
      errorMessage = mapper.writeValueAsString(errors);
    }

    response.sendError(400, errorMessage);
  }