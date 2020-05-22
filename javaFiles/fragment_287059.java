public interface JdbcDAO<T> {
    T find(Long id) ;
    T create(T entity);
    T update(T entity);
    void delete(T entity);
}

public class JdbcDAOImpl<T> {
    this.clazz = clazz;
    DaoRegistry.register (clazz, this);
}