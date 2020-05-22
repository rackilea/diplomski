@Bean(name = "tmsJdbcTemplate")
public JdbcTemplate tmsJdbcTemplate(@Qualifier("tmsDataSource") final DataSource tmsDataSource) {
    return new JdbcTemplate(tmsDataSource);
}

@Bean(name = "lhlJdbcTemplate")
public JdbcTemplate lhlJdbcTemplate(@Qualifier("lhlDataSource") final DataSource lhlDataSource) {
    return new JdbcTemplate(lhlDataSource);
}