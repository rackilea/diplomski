public class StandardJdbcTemplate extends JdbcTemplate {
    private static final int FETCH_SIZE =
            ResourceBundler.get("myjdbc").getInt("fetchSize");
    public StandardJdbTemplate(DataSource dataSource) {
        super(dataSource);
        setFetchSize(FETCH_SIZE);
    }
}

JdbcTemplate template = new StandardJdbcTemplate(dataSource);