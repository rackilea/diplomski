@Override
public String call() throws Exception {

    String partialResult ;
    // recoverable:
    try {
        partialResult = doSomeProcessing(textToConvert);
    } catch (Exception e) {
        partialResult = computeFallbackValue(textToConvert);
    }
    // non-recoverable: may throw exception which is propagated out
    String result = completeComputation(partialResult);
    return result ;
}