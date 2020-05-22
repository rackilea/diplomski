jdbcTemplate.update(
    "INSERT INTO orders (id, order_status, description) VALUES (?, ?, ?)",
    new Object[] {
        order.getId(),
        order.getStatus().toString(),
        order.getDescription()
    }
);