private List<Customer.CustomerOrderDto> customerOrderDtoList(Customer customer){
    Collection<Customer.Order> orders = customer.getOrders();
    return orders.stream()
                 .map(order -> createCustomerOrderDto(customer, order))
                 .collect(Collectors.toList());
}

private Customer.CustomerOrderDto createCustomerOrderDto(Customer customer, Customer.Order order){
    Customer.CustomerOrderDto dto = new Customer.CustomerOrderDto();

    return dto;
}