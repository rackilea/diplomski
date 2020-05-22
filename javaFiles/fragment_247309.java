qb = accountDao.queryBuilder();
qb.where()...;
List<Account> accounts = qb.query();

// build a list of account-ids
List<Long> accountIds = new ArrayList<>();
for (Account account : accounts) {
    accountIds.add(account.getId());
}

// now use this list of ids to get your other entities
List<Order> orders = orderDao.queryBuilder().where().in("accountId", accountIds).query();
// now you have a list of orders for all of your ids
// you will need to associate each order with its account