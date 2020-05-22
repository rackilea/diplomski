public User getUserByEmail( final String email )
  {
    return jdbcTemplate.query( SELECT_USER_BY_EMAIL, new PreparedStatementSetter() {
      public void setValues( PreparedStatement preparedStatement )
        throws SQLException
      {
        preparedStatement.setString( 1, email );
      }
    }, new ResultSetExtractor<User>() {...}
    } );
  }