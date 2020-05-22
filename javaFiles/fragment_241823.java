return jdbcTemplate
      .query( SELECT_ALL_USERS, new ResultSetExtractor<List<User>>() {
        public List<User> extractData( ResultSet resultSet )
          throws SQLException, DataAccessException
        {
          List<User> list = new ArrayList<User>();
          while ( resultSet.next() ) {
            User user = new User(...);  
            list.add( user );
          }
          return list;
        }
      } );