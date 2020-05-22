@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {

    private Class<T> clazz;

    protected GenericDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    // other methods omitted

    public T findById(long id) {
        // method implementation
    }
}