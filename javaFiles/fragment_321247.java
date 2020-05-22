TransactionSynchronizationManager.registerSynchronization(
    new TransactionSynchronizationAdapter() {
        @Override
        public void afterCompletion() {
            ... clear the ThreadLocal ...
        }
    }
);