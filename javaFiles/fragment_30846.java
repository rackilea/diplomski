public OrderDTO save(OrderDTO orderDTO) {
   log.debug("Request to save Order : {}", orderDTO);
   Product purchased = productRepository.findById(orderDTO.getProduct().getId());
   Order order = OrderMapper.INSTANCE.toEntity(orderDTO);
   Objects.requireNonNull(purchased, "You cannot buy a non existing product");

   // now prevent Hibernate from creating a new product in the database (and the user from manipulating the product)
   order.setProduct(purchased);
   purchased.setStock(purchased.getStock() - order.getQuantity());

   // this save operation will also trigger the product to be saved (cascading), but it is cleaner to explicitly trigger a save operation.
   order = orderRepository.save(order);
   productRepository.save(purchased);
   return OrderMapper.INSTANCE.toDto(order);
}