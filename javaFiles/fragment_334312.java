class Order
{

    private long id;
    private Set<OrderItem> orderItems;
    ...
    public Set<OrderItem> getOrderItems()
    {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems)
    {
        this.orderItems = orderItems;
    }
}

class OrderItem
{
    private Order order;
    ...
    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
}