Criteria criteria = Criteria.forClass(PizzaOrder.class,"pizzaOrder");
DetachedCriteria sizeCriteria = DetachedCriteria.forClass(Pizza.class,"pizza");
sizeCriteria.add("pizza_size_id",1);
sizeCriteria.add(Property.forName("pizza.pizza_order_id").eqProperty("pizzaOrder.pizza_order_id"));
criteria.add(Subqueries.exists(sizeCriteria.setProjection(Projections.property("pizza.id"))));
List<pizzaOrder> ordersWithOneSmallPizza = criteria.list();