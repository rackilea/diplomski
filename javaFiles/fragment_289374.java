// execute update SQL stetement
  preparedStatement.addBatch();
  rowCount++;
  if(rowCount % 500 == 0){
      preparedStatement.executeBatch(); 
  }
  System.out.println(rowCount);