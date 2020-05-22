public class DatabaseOperations {
    private DataSource dataSource;

    @Resource(name = "jdbc/Oracle")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}