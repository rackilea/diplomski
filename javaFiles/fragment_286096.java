QueryBuilder<Performance, String> performancesQB = performanceDao.queryBuilder();
SelectArg performanceSelectArg = new SelectArg();
performancesQB.where().lt("date", performanceSelectArg);
performancesQB.orderBy("date", false);

// query for Order objects, where the id matches
QueryBuilder<Order, String> ordersQB = orderDao.queryBuilder();
ordersQB.join(performancesQB).where().isNull("user_id");
pastOrdersQuery = ordersQB.prepare();