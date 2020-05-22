Criteria criteria = session.createCriteria(MyEntity.class);

    if (orderDirection.equals("desc")) {
        criteria.addOrder(Order.desc(orderProperty));
    }
    else {
        criteria.addOrder(Order.asc(orderProperty));
    }