AccountSync accountsync;
while (entitiesItr.hasNext()) {
    accountsync = new AccountSync();
    Account account = (Account) entitiesItr.next();
    accountsync.setAccountName(account.getName());
    accountsList.add(accountsync);
    System.out.println("1st-name->"+account.getName());
}