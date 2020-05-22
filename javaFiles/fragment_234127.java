public OrderDTO(Order order) 
{
    this.adress = order.getAddress();
    this.deliveryType = order.getDeliveryType();
    this.restaurant = order.getRestaurant();
    this.dishes = new ArrayList<>(order.getDishes());
}