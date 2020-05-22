void handleException
        (Exception e, Class<? extends Exception>... acceptableExceptionNames)
        throws MyException {

    boolean isRetryable = false;

    for(Class<?> acceptableExceptionName: acceptableExceptionNames) {
        if (acceptableExceptionName.isInstance(e)) {
            isRetryable = true;
            break;
        }
    }

    if (isRetryable) {
        // log retryable
    } else {
        // log error
    }

    throw new MyException(isRetryable, "Failed");
}