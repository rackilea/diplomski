class MyExecutionException extends MyLogicException {
    //what happened in the first place
    Throwable getOriginException();

    // what have we tried?
    Throwable getRecoveryException();

     // more than 1 thing can happen in recovery, order is important, hence list
    List<Throwable> getAllExceptions(); 
}