public BigDecinmal balance(Long userId) {
    BigDecimal balance = new BigDecimal("0.00");
    for (Transaction t: transactionList) {
        if (userId.equals(t.getUserId())) {
            balance = balance.add(t.getBalanceChange());
        }
    }
}