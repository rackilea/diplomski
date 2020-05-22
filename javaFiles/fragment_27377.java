public enum UserActivity {
    INSTANCE;

    private DataSource _dataSource;
    private JdbcTemplate _jdbcTemplate;

    private UserActivity() {
        this._dataSource = MysqlDb.getInstance().getDataSource();
        this._jdbcTemplate = new JdbcTemplate(this._dataSource);
    }

    public void dostuff() {
     ...
    }
}

// use it as ...
UserActivity.INSTANCE.doStuff();