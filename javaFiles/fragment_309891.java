private static void updateData(Order order) {
    Session session = getSession();
    session.getTransaction().begin();

    // To update existing OrderLines

    List<OrderLine> orderLines = new ArrayList<OrderLine>();
    for (OrderLine orderLine : order.getOrderLines()) {
        OrderLine ol = new OrderLine();
        ol.setIdOrderLine(orderLine.getIdOrderLine());
        ol.setOrder(orderLine.getOrder());
        ol.setQuantity(orderLine.getQuantity() + 10);
        orderLines.add(ol);
    }
    for (OrderLine orderLine : orderLines) {
        //session.merge(orderLine); -- merge() is used when we are not closing the session using session.close()
        session.update(orderLine);
    }

    // To create new OrderLine and updating existing Order
    OrderLine ol1 = new OrderLine();
    ol1.setOrder(order);
    ol1.setQuantity(80);
    order.setStartDate(new SimpleDateFormat("yyyy-MM-dd")
            .format(new Date()));
    order.addOrderLine(ol1);

    session.save(ol1);
    //session.merge(order);
    session.update(order);
    session.getTransaction().commit();
    session.close();
}