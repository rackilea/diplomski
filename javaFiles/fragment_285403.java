try(PreparedStatement stmt = connection.prepareStatement(sql)) {
    for(value : valueList) {   
      stmt.clearParameters();     
      stmt.setParameter(1, value);
      stmt.addBatch();
    }
    stmt.executeBatch();
 }