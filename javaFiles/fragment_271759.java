int x = 1000;//your total records
int y = 100;//set of records that need to be updated
String sql = "update xxx set xx = ?,yy=? ";
Connection dbConnection = null;
PreparedStatement preparedStatement = null;
try{
    dbConnection = getDBConnection(); //get your db connetion
    preparedStatement = dbConnection.prepareStatement(sql);
    dbConnection.setAutoCommit(false);
    for(int i = 1;i < x;i++){
        preparedStatement.setInt(1, 101);
        preparedStatement.setString(2, "zzzz");
        preparedStatement.addBatch();
        if(i % y == 0){
            try{
                preparedStatement.executeBatch();// update y records
            }catch(Exception e){
                x -= 100;  //if failed ,roll back x 
            }
        }
    }
    preparedStatement.executeBatch(); // update rest of the reords
    dbConnection.commit();
}catch(Exception e){

}