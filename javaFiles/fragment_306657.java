// Call the original method to convert the orders
List<Order> orders = QueryUtils.toOrders(sort, root, builder);
for (Order order : orders) {
  // Fetch the original order object from the sort for comparing
  SingularAttributePath orderExpression = (SingularAttributePath) order.getExpression();
  Sort.Order originalOrder = sort.getOrderFor(orderExpression.getAttribute().getName());
  // Check if the original order object is instantiated from my custom order class
  // Also check if the the order should be natural
  if (originalOrder instanceof NaturalSort.NaturalOrderm && ((NaturalSort.NaturalOrder) originalOrder).isNatural()){
    // replace the order with the custom class
    Order newOrder = new OrderImpl(new NaturalSingularAttributePathImpl(builder, expression.getJavaType(), expression.getPathSource(), expression.getAttribute()));
    resultList.add(newOrder);
  }else{
    resultList.add(order);
  }
}
return resultList;