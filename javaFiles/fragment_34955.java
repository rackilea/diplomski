private void nativeBatchInsertUsers(JdbcTemplate jdbcTemplate, final List<UsersT> batchInsertUsers) {
       String sqlInsert =   "INSERT INTO PUBLIC.USERS_T (id, password,  ... )"; // etc.
       jdbcTemplate.batchUpdate(sqlInsert, new BatchPreparedStatementSetter() {

           @Override
           public int getBatchSize() {
             return batchInsertUsers.size();
           } 

           @Override
           public void setValues(PreparedStatement ps, int i) throws SQLException {
              ps.setInt(1, batchInsertUsers.get(i).getId()); // ID (provided by ourselves)
              ps.setDate(2, batchInsertUsers.get(i).getCreatedDate());
              //etc.
           }            
       });
    }