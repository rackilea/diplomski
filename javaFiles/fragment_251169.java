private boolean matchSomeError(final List<ErrorAtMessageLevel> errorList) {
    return errorList.stream()
        .map(ErrorAtMessageLevel::getErrorSegment)
        .filter(Objects:nonNull)
        .map(ErrorSegment::getErrorDetails)
        .filter(Objects:nonNull)
        .anyMatch(errorDetails -> SOME_FANCY_ERROR_CODE.equals(errorDetails.getErrorCode()));
}