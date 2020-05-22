String sql = " some sql query";

List<SqlRow> row = Ebean.createSqlQuery(sql).findList(); //Ebean return the row list 

if ((row.size() == 0)){ //if row is there is no value then allocate 700    
  avgSteps=700;         
}
else {
  for(SqlRow sqlrow : row) {        
     avgSteps = sqlrow.getLong("step");
  }
}