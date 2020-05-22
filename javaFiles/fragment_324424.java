@Transactional
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public Collection<Product> loadProductsByCategory(String category) {
        return this.sessionFactory.getCurrentSession()
                .createQuery(
                    "from test.Product product where product.category=?")
                .setParameter(0, category)
                .list();
    }
}