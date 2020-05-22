@Component
@RabbitListener(queues = "high-priority-orders", containerFactory="orders")
public class HighPriorityOrdersListener {

 @RabbitHandler
 public void onOrderPlaced(OrderPlacedEvent orderPlaced) {
   //...
 }
}