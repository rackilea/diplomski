link = new Link("cancel") {
    @Override 
    public void onClick() {
        new TransactionTemplate(platformTransactionManager, TRANSACTION_DEFINITION).execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                Order order = orderDAO.load(orderId);
                order.setCancelledTime(timeSource.getCurrentTime());      
            }
        }
    } 
};