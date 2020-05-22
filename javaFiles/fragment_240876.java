// R is the type of the repository
public abstract class AbstractService<T,R extends BaseRepository> {
    protected abstract R getRepository();

    public void add(T entity) {
        getRepository().save(entity);
    }
}