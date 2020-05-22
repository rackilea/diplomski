try {
        retVal = invocation.proceed();
}
catch (Throwable ex) {
        completeTransactionAfterThrowing(txInfo, ex);
        throw ex;
}