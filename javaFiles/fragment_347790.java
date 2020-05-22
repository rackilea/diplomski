void methodPerformingTwoOperations() throws Exception {
    Exception firstOperationErrror = null;
    Exception secondOperationError = null;

    try {
        performFirstOperation();
    } catch(Exception e) {
        firstOperationError = e;
    }

    try {
        performSecondOperation();
    } catch(Exception e) {
        secondOperationError = e;
    }

    throwExceptionAsPerErrors(firstOperationError, secondOperationError);

}

void throwExceptionAsPerErrors(Exception firstOperationError, Exception secondOperationError) {
    // depending upon exceptions compose and throw new exception from here
}