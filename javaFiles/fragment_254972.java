@Override
    public Integer insertOrUpdate(final Email e) {
        if (e == null) throw new IllegalArgumentException();

        if (e.getIdEmail() != null) {
            String sql = "UPDATE Email SET email=? WHERE idEmail=?";
            jdbcTemplate.update(sql, e.getEmail(), e.getIdEmail());
            return e.getIdEmail();
        }
        else {
            final String sql = "INSERT IGNORE INTO Email (email) VALUES (?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, e.getEmail());
                    return ps;
                }
            }, keyHolder);
            if (keyHolder.getKey() != null)
                return ((Long) keyHolder.getKey()).intValue();
            else {
                String sql2 = "SELECT idEmail FROM Email WHERE email=?";
                return jdbcTemplate.queryForObject(sql2, new Object[] {e.getEmail()}, Integer.class);
            }
        }
    }