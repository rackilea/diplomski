public List<User> findByManyParams(int param1, int param2, String param3)
{
    return getJdbcTemplate().query(
            "SELECT * FROM users WHERE foo=? AND bar=? AND foobar=?",
            new UserRowMapper(),
            param1,
            param2,
            param3
        );
}