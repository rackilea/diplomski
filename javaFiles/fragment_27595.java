public abstract class CrudDao<T> {

    private Class<T> type;

    public CrudDao(Class<T> type){
        this.type = type;
    }

    @Transactional
    public T getById(,int postId) {
    return sessionFactory.getCurrentSession().get(type, postId);
}
}