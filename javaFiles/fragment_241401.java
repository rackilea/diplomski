public List<User> findById(int userId)
{
    return getJdbcTemplate().query(
            "SELECT * FROM users WHERE user_id=?",
            new UserRowMapper(),
            userId
        );
}