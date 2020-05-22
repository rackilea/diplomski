public List<BankAccount> findWithBalance(int amount) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<BankAccount> cq = cb.createQuery(BankAccount.class);
    Root<BankAccount> from = cq.from(BankAccount.class);

    ParameterExpression<Integer> balance = cb.parameter(Integer.class);
    cq.select(from);

    //Here is the trick!
    Predicate predicate = cb.gt(from.<Integer> get("balance"), balance);

    cq.where(predicate);
    cq.orderBy(cb.asc(from.get("ownerName")));

    TypedQuery<BankAccount> query = em.createQuery(cq);

    query.setParameter(balance, amount);

    return query.getResultList();
}