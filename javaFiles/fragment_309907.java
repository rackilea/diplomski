try {
     sql = "SELECT id FROM tableNmae WHERE column_name ='"+ coulmn value+ "'";
     id= jdbcTemplate.queryForObject(sql, Long.class);
} 
catch (EmptyResultDataAccessException e) {
   if(log.isDebugEnabled()){
       log.debug(e);
   }
   return null
}