void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
    Account from = em.find(Account.class, fromAccountId); // from is managed by JPA
    Account to = em.find(Account.class, ftoAccountId); // to is managed by JPA
    from.remove(amount);
    to.add(amount);

    // now the transaction ends, Hibernate sees that the state of from and to 
    // has changed, and it saves the entities automatically before the commit
}