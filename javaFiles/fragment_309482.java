KeyHolder holder = new GeneratedKeyHolder();

getJdbcTemplate().update(new PreparedStatementCreator() {           

                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql.toString(),
                        Statement.RETURN_GENERATED_KEYS); 
                    ps.setString(1, person.getUsername());
                    ps.setString(2, person.getPassword());
                    ps.setString(3, person.getEmail());
                    ps.setLong(4, person.getRole().getId());
                    return ps;
                }
            }, holder);

Long newPersonId = holder.getKey().longValue();