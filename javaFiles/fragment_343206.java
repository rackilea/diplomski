@Around("@annotation(com.softjourn.coin.server.aop.annotations.SaveTransaction)")
public Transaction saveTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
    Transaction transaction = prepareTransaction(joinPoint);
    try {
        joinPoint.proceed();
        transaction.setStatus(TransactionStatus.SUCCESS);
        return transaction;
    } catch (Throwable e) {
        transaction.setStatus(TransactionStatus.FAILED);
        transaction.setError(e.getLocalizedMessage());
        throw e;
    } finally {
        transactionRepository.save(transaction);
    }
}