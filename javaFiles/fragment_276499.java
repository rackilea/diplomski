public boolean login(String userid, String userpass) throws SQLException {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String query = "SELECT * FROM user WHERE username = ? AND password = ?";
    try{
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,userid);
        preparedStatement.setString(2,userpass);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return true;
        }
        else {
           // System.out.println(resultSet.next());
            return false;
        }
    }
    catch (Exception e){
        return false;
    }
    finally {
        preparedStatement.close();
        resultSet.close();
    }
       return false;

}