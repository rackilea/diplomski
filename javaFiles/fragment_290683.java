You can do something like:-

public void closeConnection() {
    try{
    if(connection==null)
    {
    //Code to create connection and use DB operations
    }
}
    catch (SQLException e) {
            e.printStackTrace();
        }
    finally{
            if(connection!=null){
              try {
                connection.close();
              } catch (SQLException e) {
                e.printStackTrace();
              }
    }


        }