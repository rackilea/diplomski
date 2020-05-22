public class CustomerRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustId(rs.getInt("CUST_ID"));
        customer.setName(rs.getString("NAME"));
        customer.setAge(rs.getInt("AGE"));
        return customer;
    }

}

public Customer findByCustomerId(int custId) {
    String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
    Customer customer = (Customer)getJdbcTemplate().queryForObject(sql, new Object[] { custId }, new CustomerRowMapper());
    return customer;
}