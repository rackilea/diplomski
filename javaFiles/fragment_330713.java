transTemplate.execute( new TransactionCallbackWithoutResult()
        {       
                @Override
                protected void doInTransactionWithoutResult( TransactionStatus status)
                {
                    status.setRollbackOnly();
                    //business logic
                }

        });