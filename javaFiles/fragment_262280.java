DefaultTransactionDefinition def = new DefaultTransactionDefinition();
def.setName("transactionName");
def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
TransactionStatus ts = txManager.getTransaction(def);

//Body Code

txManager.commit(ts);