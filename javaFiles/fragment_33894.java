public <T> T findByPk(Class<T> clazz, Object pk) throws Exception {
    T obj = null;
    try {
        obj = entity().find(clazz, pk);
    } catch (Exception e) {
        throw e;
    }
    return obj;
}