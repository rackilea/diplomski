private void nativeBatchInsertStudyParticipants(JdbcTemplate jdbcTemplate, final List<UsersT> batchInsertUsers) {
   String sqlInsert =   "INSERT INTO PUBLIC.STUDY_PARTICIPANTS_T (id, ... )"; // etc.
   jdbcTemplate.batchUpdate(sqlInsert, new BatchPreparedStatementSetter() {

       @Override
       public int getBatchSize() {
         return batchInsertUsers.size();
       } 

       @Override
       public void setValues(PreparedStatement ps, int i) throws SQLException {
          ps.setInt(1, batchInsertUsers.get(i).getStudyParticipants().getId()); // ID (provided by ourselves)
          //etc.
       }            
   });
}