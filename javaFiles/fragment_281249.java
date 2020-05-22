@Component
class CustomerBean {

    private String custName;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setCustName(String custName) {
        this.custName = custName;
        jdbcTemplate.update(query);
    }
}