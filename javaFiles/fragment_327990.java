@Test
public void updateExistingAccount() {
    accountDao.createAccount(newAccount);
    dbAccount = accountDao.findAccount(newAccount.getId);
    dbAccount.setName("");
    dbAccount.setSurname("");
    // etc...
    accountDao.updateAccount(dbAccount);
    dbAccountUpdated = accountDao.findAccount(newAccount.getId);
    assertEquals(accountDao.findAccount(dbAccountUpdated.getId()), dbAccount);
}