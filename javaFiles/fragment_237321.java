Customer topCustomer = orders.stream()
        .collect(Collectors.groupingBy(Order::getCustomer,
                Collectors.mapping(
                        order -> order.getProduct()
                                      .getPrice()
                                      .multiply(new BigDecimal(order.getQuantity())),
                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))))
        .entrySet().stream()
        .max(Comparator.comparing(Entry::getValue))
        .map(Entry::getKey)
        .orElse(null);