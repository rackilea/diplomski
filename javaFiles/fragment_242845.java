public List<Order> findAllOrders() 
{
    return jdbcTemplate.query(
        "SELECT * FROM orders",
        new String[]{},
        (rs, rowNum) -> new Order(rs.getInt("id"), OrderStatus.valueOf(rs.getString("order_status")), rs.getString("description"))
    );
}