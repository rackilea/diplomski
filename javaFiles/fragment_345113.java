QueryBuilder<Account, String> queryBuilder = dao.queryBuilder();
Where<Account, String> where = queryBuilder.where();
SelectArg selectArg = new SelectArg();
// define our query as 'name = ?'
where.eq("name", selectArg);
// prepare it so it is ready for later query or iterator calls
PreparedQuery<Account> preparedQuery = queryBuilder.prepare();