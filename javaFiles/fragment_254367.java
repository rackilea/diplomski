TransactionTemplate tt = new TransactionTemplate(transactionManager);
    tt.execute(new TransactionCallbackWithoutResult() {
        @Override
        protected void doInTransactionWithoutResult(TransactionStatus status) {
            ObjectIdentity oid = new ObjectId
            entityImpl(clazz.getCanonicalName(), securedObject.getId());
                // your aclService operation here: 
                aclService.deleteAcl(oid, true);            
        }
    });