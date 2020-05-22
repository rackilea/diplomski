Optional<Entry<Customer, BigDecimal>> topCustomerEntry = orders.stream()
        .collect(Collectors.groupingBy(Order::getCustomer,
                Collectors.mapping(order -> 
                    order.getProduct()
                            .getPrice()
                            .multiply(new BigDecimal(order.getQuantity())),
                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))))
        .entrySet().stream()
        .max(Comparator.comparing(Entry::getValue));

BigDecimal topValue = null; //total value for top customer
Customer customer = null;   //customer with most purchases

if(topCustomerEntry.isPresent()) {
    topValue = topCustomerEntry.get().getValue();
    customer = topCustomerEntry.get().getKey();
}