SELECT new com.pizzaboy.dto.OrderDTO(o)
FROM Order o 
    JOIN o.user u
WHERE u.id=:id

EntityGraph<Order> graph = entityManager.createEntityGraph(Order.class);
graph.addAttributeNodes(Order_.deliveryType, Order_.restaurant);
graph.addSubgraph(Order_.dishes);

entityManager.createQuery(hql)
    .setHint("javax.persistence.fetchgraph", graph)
    .setParameter("id", userId)
    .getResultList();