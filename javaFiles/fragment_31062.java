public class GenericJdbcDao<T> implements Dao<T> {

    private String tableName;
    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<T> rowMapper;
    public void setRowMapper(final RowMapper<T> rowMapper) {
        this.rowMapper = rowMapper;
    }

    public T get(final Long id) {
        return jdbcTemplate.queryForObject(
            // please don't do it like this, this is just a quick example
            "select * from " + tableName + " where id=" + id, rowMapper);
    }
}