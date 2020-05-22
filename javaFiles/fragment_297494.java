void handleException
        (Exception e, Class<? extends Exception>... acceptableExceptionNames)
        throws MyException {

    boolean isRetryable = 
        Arrays.stream(acceptableExceptionNames).anyMatch(x -> x.isInstance(e));

    if (isRetryable) {
        // log retryable
    } else {
        // log error
    }

    throw new MyException(isRetryable, "Failed");
}