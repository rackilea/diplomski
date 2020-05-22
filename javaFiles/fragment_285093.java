public boolean checkForUser(String username){
    try(Connection con = this.connect();
            PreparedStatement pstmt = createPreparedStatementRegistrate(conn, username);
            ResultSet rs= pstmt.executeQuery();)
            {
            if (rueck.next()){
                //do some stuff
            }
    }catch(SQLException e){
        e.printStackTrace();
    }
    return null;
}