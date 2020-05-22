@Transactional
@Override
public Order acceptOrder(long orderId){
    Order order = getOrderById(orderId);                                  // 1
    orderDao.updateOrderStatus(OrderStatus.PENDING_COMPLETION, orderId);  // 2
    //commit the transaction                                              // 3
    return getOrderById(orderId);                                         // 4
}