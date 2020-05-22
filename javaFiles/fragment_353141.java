public void transferMoney(Long sourceAccountId, Long targetAccountId, BigDecimal amount) {
    Account source = accountDAO.getById(sourceAccountId);
    Account target = accountDAO.getById(targetAccountId);
    if (source.getBalance().compareTo(amount) < 0) {
        throw new NotEnoughMoneyException();
    }
    source.decrementBalance(amount);
    target.incrementBalance(amount);
    auditDAO.insertTransaction(sourceAccountId, targetAccountId, amount);
    // other business logic
}