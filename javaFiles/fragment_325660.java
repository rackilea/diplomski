public List<Transaction> findTransactions(Long accountId) { 
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Transaction> query = builder.createQuery(Transaction.class);
        Root<Transaction> _transaction = query.from(Transaction.class);

        Path<Account> _account = _transaction.get(Transaction_.account);
        Path<Long> _accountId = _account.get(Account_.id);

        query.where(builder.equal(_accountId, accountId));
        return entityManager.createQuery(query).getResultList();
    }