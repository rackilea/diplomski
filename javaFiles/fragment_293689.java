@PreDestroy
public void preDestroy() {
    try {
        jdbcTemplate.execute("SHUTDOWN COMPACT");
    } catch (DataAccessException e) {
        // do nothing
    }
}