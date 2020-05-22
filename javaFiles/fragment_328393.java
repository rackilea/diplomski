public boolean isLoggedInGoogle() {
    AccountManager manager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
    Account[] list = manager.getAccounts();

    for (Account account : list) {
        if (account.type.equalsIgnoreCase("com.google")) {
            return true;
        }
    }

    return false;
}