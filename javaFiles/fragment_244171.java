@Aspect
class TransactionAspect extends TransactionSynchronizationAdapter {

    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void registerTransactionSyncrhonization() {
        TransactionSynchronizationManager.registerSynchronization(this);

    }

    @Override
    public void afterCompletion(int status) {
        // code 
    }
}