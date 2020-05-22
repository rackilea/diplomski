@Stateless
public class OrderBillingServiceBean implements OrderBillingService {
    ...

    @Asynchronous
    public void billOrder(Order order) {
        try {
            // Attempt to charge the order.
            bill(order);
            // Send email notification of billing success.
            notifyBillingSuccess(order);
            order.setStatus(OrderStatus.COMPLETE);
        } catch (BillingException be) {
            // Send email notification of billing failure.
            notifyBillingFailure(be, order);
            order.setStatus(OrderStatus.BILLING_FAILED);
        } finally {
            update(order);
        }
    }

    ...
}