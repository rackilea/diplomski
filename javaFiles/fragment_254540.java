public boolean removeNumber(int accountNumber) {
    for (int i = 0; i < accounts.length; i++) {
        if (accounts[i].getAccountNumber() == accountNumber) {
            System.arraycopy(accounts, i + 1, accounts, i, accounts.length - i - 1);
            accounts[accounts.length - 1] = null;
            return true; // Found and removed
        }
    }
    return false; // Not found, so nothing removed
}