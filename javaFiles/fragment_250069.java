protected TableModel populateTable(){

   TableModel model = null;
   String query="Select * from clienttable";
   try {  

       //Call connectDB method to connect to database
       Connection dbCon=mySqlConnection.ConnectDB();

       //Prepare the query
       PreparedStatement pst=dbCon.prepareStatement(query);

       //return ResultSet
       ResultSet rs=pst.executeQuery(query);
       model = DbUtils.resultSetToTableModel(rs);


   } catch (SQLException ex) {
       Logger.getLogger(databaseHandler.class.getName()).log(Level.SEVERE, null, ex);
   }

   return model;
}