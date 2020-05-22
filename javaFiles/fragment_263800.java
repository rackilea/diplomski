DetachedCriteria ids = DetachedCriteria.forClass(ProductStock.class, "stock");
ids.add(Restrictions.eq("stock.stockLevel", 0));
ids.setProjection(Property.forName("productId"));

DetachedCriteria criteria = DetachedCriteria.forClass(Order.class, "order");
criteria.createAlias("order.orderItems", "items", CriteriaSpecification.LEFT_JOIN);
criteria.add(Subqueries.propertyIn("items.productId", ids));
criteria.setResultTransformer(Criteria.ROOT_ENTITY);