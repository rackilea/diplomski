@Stateless
public class OrderBillingServiceBean implements OrderBillingService {
    ...

    @Asynchronous
    public Future<OrderStatus> billOrder(Order order) {
        try {
            // Attempt to charge the order.
            bill(order);
            // Send email notification of billing success.
            notifyBillingSuccess(order);
            return new AsyncResult<OrderStatus>(OrderStatus.COMPLETE);
        } catch (BillingException be) {
            // Send email notification of billing failure.
            notifyBillingFailure(be, order);
            return new AsyncResult<OrderStatus>
                (OrderStatus.BILLING_FAILED);
        }
    }

    ...
}