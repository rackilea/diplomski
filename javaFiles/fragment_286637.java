public interface GenericRepository<T extends BaseClass> extends CouchbaseRepository<T, String> {

    public List<T> findByType(BaseData.Type type);

    public default List<T> findAll(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return findByType(clazz.newInstance().getType());
    }
}