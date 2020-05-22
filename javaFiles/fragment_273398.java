public abstract class AbstractDAO<T extends Serializable> {

    protected EntityManager em;
    protected Class<?> entityClass;

    public AbstractDAO(EntityManager em, Class<?> c) {
        this.em = em;
        this.entityClass = c;
    }

    @SuppressWarnings("unchecked")
    public T findById(Serializable id) {
        if (id == null) {
            throw new PersistenceException("id cannot be null");
        }
        return (T) em.find(entityClass, id);
    }

}

public class CustomerDAO extends AbstractDAO<Customer> {

    public CustomerDAO(EntityManager em) {
        super(em, Customer.class);
    }
}

public class OrderDAO extends AbstractDAO<Order> {

    public OrderDAO(EntityManager em) {
        super(em, Order.class);
    }
}