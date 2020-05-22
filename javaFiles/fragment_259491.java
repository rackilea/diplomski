public boolean withdraw(String pNo, int accountId, double amount){
    for(Customer pers: customerList) {
        if (pers.getPersonalNumber().equals(pNo)) {
            for (Account account : pers.getAllAccounts()) {
                if (account.getAccountNumber() == accountId) {
                    account.withdraw(amount);
                }
            }
        }
    }
    return false; //this should be true. this denotes  the whole process
}