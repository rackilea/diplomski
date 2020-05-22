// Get an account object by ID
public Account getAccount(long id) {
    session = sessionFactory.getCurrentSession();
    String queryString = "FROM Account where id = :acctId";
    Query query = session.createQuery(queryString);
    query.setLong("acctId", id);
    return (Account) query.uniqueResult();
}

// Set account object's attributes
public Account updateAccount(Account acct, UserDetail userInfo) {
    acct.setName(account.getName());
    acct.setPhone(account.getPhone());
    acct.setRating(account.getRating());
    acct.setFax(account.getFax());
    acct.setAccountNumber(account.getAccountNumber());
    if (!ValidateUtil.isNullOrEmptyCheckStr(account.getParentAccount()
            .getName())) {
        acct.setParentAccount(account.getParentAccount());
    }
    acct.setWebsite(account.getWebsite());
    acct.setType(account.getType());
    acct.setIndustry(account.getIndustry());
    acct.setNumberOfEmployees(account.getNumberOfEmployees());
    acct.setDescription(account.getDescription());
    acct.setAnnualRevenue(account.getAnnualRevenue());
    acct.setEmail(account.getEmail());

    acct.setBillingAddress(account.getBillingAddress());
    acct.setShippingAddress(account.getShippingAddress());

    Users user = new Users();
    user.setId(userInfo.getUserId());
    // modified details
    account.setModifiedBy(user);
    account.setModifiedDate(new Date());
    updateAccount(acct);
}

// Update the account object in the database. Here transaction is necessary
@Transactional
private Account updateAccount(Account acct) {
    session = sessionFactory.getCurrentSession();
    //update use merge
    System.out.println("update Account" + acct.getId());
    return session.merge(acct);
}

// This is for testing
public void testUpdate(long id, UserDetail userInfo) {
    Account acc = getAccount(id);
    updateAccount(acct, userInfo);
}