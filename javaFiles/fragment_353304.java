public List<Order> getOrderByCustomerId(Customer customer) {
    Criteria criteria = session.createCriteria(Order.class);
    List<Order> res = (List<Order>) criteria.add(Restrictions.eq("customer",customer)).list();

    for (Order order : res)
        order.getCustomer().getShippingAddress().size();

    return res;
}