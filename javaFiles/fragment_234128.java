public OrderDTO(Order order) 
{
    Hibernate.initialize(order.getAddress());
    this.adress = order.getAddress();

    Hibernate.initialize(order.getDeliveryType());
    this.deliveryType = order.getDeliveryType();

    Hibernate.initialize(order.getRestaurant());
    this.restaurant = order.getRestaurant();

    Hibernate.initialize(order.getDishes());
    this.dishes = new ArrayList<>(order.getDishes());
}