String error = "BAD_REQUEST";
HttpStatus httpStatus = Arrays.stream(HttpStatus.values())
        .filter(status -> status.name().equals(error))
        .findAny()
        .orElse(HttpStatus.INTERNAL_SERVER_ERROR);
int errorIntCode = httpStatus.value();