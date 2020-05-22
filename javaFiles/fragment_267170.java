@Stateless
public class ShoppingServiceLocal implements ShoppingService {

    @EJB
    private ProductDAO productDAO;

    @EJB
    private OrderDAO orderDAO;

    @Override
    public List<Product> searchProducts(String query) {
        return productDAO.find(query);
    }

    @Override
    public Order orderProduct(User user, Product product, int quantity) {
        product.setAvailable(product.getAvailable() - quantity);
        productDAO.update(product);
        Order order = new Order(user.getId(), product.getId(), quantity);
        orderDAO.create(order);
        return order;
    }

}