public boolean Login(){
boolean valid = true;
    try {
        String stmt = "SELECT * From TBLUser where UserName = ? and Password = ? ;";
        PreparedStatement pstmt = conn.prepareStatement(stmt);
        pstmt.setString(1, sql); pstmt.setString(2, pass);
        ResultSet rs = pstmt.executeQuery();
        if(!rs.next()){
            valid = false;
        }
    } catch (SQLException e) {
        System.err.println("Error: "+e);
    }
return valid;