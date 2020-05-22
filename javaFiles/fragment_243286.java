@Component
public class YourBean {

    @Autowire
    private YourBean yourBean;

    @PostConstruct
    private init(){
        yourBean.doThingsWithOrderItems();
    }

    @org.springframework.transaction.annotation.Transactional;
    public void doThingsWithOrderItems() {
        List<Order> orders = orderRepository.findAll();
        for (Order order : orders) {
            Hibernate.initialize(orders.getOrderItems());
            // do things with orders and their order items
        }
    }
}