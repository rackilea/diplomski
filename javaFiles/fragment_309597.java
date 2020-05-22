private DataSource dataSource;
private JdbcTemplate jdbcTemplate;

public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
}

public void insert(Customer customer){

    String sql = "INSERT INTO CUSTOMER " +
        "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

    jdbcTemplate = new JdbcTemplate(dataSource);

    jdbcTemplate.update(sql, new Object[] { customer.getCustId(),
        customer.getName(),customer.getAge()  
    });

}