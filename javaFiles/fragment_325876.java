@Aggregate
public class OrderAggregate {
    public OrderAggregate(OrderRepositoryData orderRepositoryData) {
        this.orderRepositoryData = orderRepositoryData;
    }

    @AggregateIdentifier
    private Integer orderId;

    private OrderRepositoryData orderRepositoryData;

    @CommandHandler
    public void handle(CreateOrderCommand command) {
        apply(new OrderCreatedEvent(command.getOrderId()));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId=event.getOrderId();
        Order order=new Order("Order New");
        orderRepositoryData.save(order);
    }

    protected OrderAggregate() {
        // Required by Axon to build a default Aggregate prior to Event Sourcing
    }

}