public class SqliteDaoFactory implements DaoFactory<SqliteDao<? extends MyObject>> {

    private final Map<Class<? extends MyObject>, SqliteDao<? extends MyObject>> daos =
            new HashMap<>();

    public SqliteDaoFactory() {
        daos.put(Contact.class, new SqliteContactDao());
        daos.put(Customer.class, new SqliteCustomerDao());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends MyObject> SqliteDao<T> getDao(Class<T> type) {
        return (SqliteDao<T>) daos.get(type);
    }
}