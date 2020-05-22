String usr_paswd = null;
try (PreparedStatement stmt = connection.prepareStatement(
        "select passwd from mrs_user where email=?")) {
    stmt.setString(1, mail_id);
    ResulSet rs = stmt.executeQuery();
    if(rs.next()){
       usr_paswd = rs.getString(1);      
    }
}