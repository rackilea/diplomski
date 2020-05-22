private boolean isDepositRequest(String bankTransaction) {
    return Transactions.DEPOSIT.toString().equalsIgnoreCase(bankTransaction);
}

private boolean isWithdrawalRequest(String bankTransaction) {
    return Transactions.WITHDRAW.toString().equalsIgnoreCase(bankTransaction);
}

private boolean isExitRequest(String bankTransaction) {
    return Transactions.ENDTRANSACTION.toString().equalsIgnoreCase(bankTransaction);
}