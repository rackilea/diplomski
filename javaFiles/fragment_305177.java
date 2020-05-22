@Override
public PageImpl<Order> getAllProgramOrder(Pageable pageable, OrderFilter filter) {
    List<Order> orders = new ArrayList<>();


    DynamoDBQueryExpression<Order> queryExpression = new DynamoDBQueryExpression<Order>();

    queryExpression.setScanIndexForward(false);


    Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
    eav.put(":val1", new AttributeValue().withS(authenticationFacade.getProgramId()));

    queryExpression.withKeyConditionExpression("hashKey = :val1 ")
            .withExpressionAttributeValues(eav);

    PaginatedQueryList<Order> scan = mapper.query(Order.class, queryExpression);


    int start = (int) pageable.getOffset();
    int size = scan.size();
    int end = (start + pageable.getPageSize()) > size ? size : (start + pageable.getPageSize());

    if (start < size)
        for (Order o : scan.subList(start, end)) {
            orders.add(o);
        }

    return new PageImpl<Order>(orders, pageable, size);
}