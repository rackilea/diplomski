// Example: Using an Expr.or() method
Query<Order> query = Ebean.createQuery(Order.class);
query.where( 
            Expr.or(Expr.eq("status", Order.NEW),
                Expr.gt("orderDate", lastWeek));

List<Order> list = query.findList();