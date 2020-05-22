public class MyDsBean {

    private JdbcTemplate myds;

    public void setDataSource(DataSource ds) {
        this.myds = new JdbcTemplate(ds);
    }
    // Code to query data source
}