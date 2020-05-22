JsonDaoFactory jsonDaoFactory = new JsonDaoFactory();
JsonDao<Contact> contactJsonDao = jsonDaoFactory.getDao(Contact.class);
JsonDao<Customer> customerJsonDao = jsonDaoFactory.getDao(Customer.class);

SqliteDaoFactory sqliteDaoFactory = new SqliteDaoFactory();
SqliteDao<Contact> contactSqliteDao = sqliteDaoFactory.getDao(Contact.class);
SqliteDao<Customer> customerSqliteDao = sqliteDaoFactory.getDao(Customer.class);