boolean gotResults = myStmt.execute();
ResultSet rs = null;
if(!gotResults){
   System.out.println("No results returned");
} else {
   rs = myStmt.getResultSet();
}