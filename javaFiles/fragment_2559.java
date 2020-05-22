final TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

transactionTemplate.execute(new TransactionCallback<String>()
{
    @Override
    public String doInTransaction(TransactionStatus status)
    {
        //...
        return "Some result";
    }
});