package persistence;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, K extends Serializable>
{
    List<T> find();
    T find(K id);
    List<T> find(T example);

    K save(T instance);
    void update(T instance);
    void delete(T instance);
}