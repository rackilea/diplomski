transactionTemplate.execute(new TransactionCallbackWithoutResult()
{
    @Override
    protected void doInTransactionWithoutResult(TransactionStatus status)
    {
        //...
    }
});