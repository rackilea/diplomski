private String custName;
private JdbcTemplate jdbcTemplate;

public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
     this.jdbcTemplate = jdbcTemplate;
}

public void setCustName(String custName) {
   this.custName = custName;
   jdbcTemplate.update(query);
}