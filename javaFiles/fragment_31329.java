@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorDTO handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, Collection<String>> errors = new LinkedHashMap<>();
        ex.getConstraintViolations().forEach(constraintViolation -> {
            String queryParamPath = constraintViolation.getPropertyPath().toString();
            log.debug("queryParamPath = {}", queryParamPath);
            String queryParam = queryParamPath.contains(".") ?
                    queryParamPath.substring(queryParamPath.indexOf(".") + 1) :
                    queryParamPath;
            String errorMessage = constraintViolation.getMessage();
            Collection<String> perQueryParamErrors = errors.getOrDefault(queryParam, new ArrayList<>());
            perQueryParamErrors.add(errorMessage);
            errors.put(queryParam, perQueryParamErrors);
        });
        return validationException(new ValidationException("queryParameter", errors));
    }