PrepatedStatementCreator psc = new PrepatedStatementCreator() {
   public PreparedStatement createPreparedStatement(Connection conn) {
      return conn.prepareStatement(sql, resultSetType, resultSetConcurrency, 
          resultSetHoldability);
   }
}

jdbcTemplate.query(psc, ...);