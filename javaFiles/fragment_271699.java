sql = "UPDATE CUSTOMERS SET LOGINDATE=?, NFLIXCREDIT=3 WHERE USERNAME=?";
    try{
        ps = con.prepareStatement(sql);
        ps.setDate(1,currentDate);
        ps.setString(2,username);
        ps.executeUpdate();
    }catch(SQLException e){