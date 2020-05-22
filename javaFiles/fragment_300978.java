protected TransactionAttribute determineTransactionAttribute(
    AnnotatedElement ae) {
    return new DelegatingTransactionAttribute(target) {
        @Override
        public boolean rollbackOn(Throwable ex) {
           return (check is exception type as you need for rollback );
       }
};