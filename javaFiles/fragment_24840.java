public class JsonDaoFactory implements DaoFactory<JsonDao<? extends MyObject>> {

    private final Map<Class<? extends MyObject>, JsonDao<? extends MyObject>> daos =
            new HashMap<>();

    public JsonDaoFactory() {
        daos.put(Contact.class, new JsonContactDao());
        daos.put(Customer.class, new JsonCustomerDao());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends MyObject> JsonDao<T> getDao(Class<T> type) {
        return (JsonDao<T>) daos.get(type);
    }
}