private boolean accountExists = false;

    AccountManager am = AccountManager.get(this); 
Account[] accounts = am.getAccountsByType("com.mycustomtype");
if(accounts.length >= 1) {
    accountExists = true;
}