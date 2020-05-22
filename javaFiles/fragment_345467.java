Account maxAccount = null;
for (Account account : accounts) {
    if (maxAccount == null || 
        account.getAccountNumber().compareTo(maxAccount.getAccountNumber()) > 0) {
        maxAccount = account;
    }
}