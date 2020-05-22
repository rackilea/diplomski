public void insertRowInDB(List cellValues){
    Connection con = null;
    PreparedStatement preparedStatement = null;
    try{            
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/databaseName?"
                                      + "user=sqlUser&password=sqlPassword");
         String sql = "INSERT INTO tableName(field1, field2, ..., fieldN) VALUES (?,?,...,?)";
         preparedStatement = con.prepareStatement(sql);
         int paramIndex = 1;
         for(Object cell : cellValues){
             preparedStatement.setObject(paramIndex, cell);
             paramIndex++;
         }
         int status = preparedStatement.executeUpdate();
         //DO something with the status if needed
    } catch(SQLException ex) { 
          /* log the exception */
    } finally {
        try{
            preparedStatemnt.close();
            con.close();
        } catch(SQLException ignored) {}
    }
}