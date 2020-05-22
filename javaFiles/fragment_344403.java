Map<String, Set<String>> fieldErrorWithMessages = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .collect(Collectors.groupingBy(
                FieldError::getField,
                Collectors.mapping(
                        error -> message.getMessage(error.getCodes()[0], null, locale),
                        Collectors.toSet())));