PreparedStatement pstmt1 = null;
PreparedStatement pstmt2 = null;
ResultSet rs = null;
try {

    String userInput = userBox.getText();

    String query = "SELECT name FROM accounts where name=?";
    pstmt1 = con.preparedStatement(query);
    pstmt1.setString(1, userInput);

    rs = pstmt1.executeQuery();

    if(rs.next()) {
            pstmt2 = con.prepareStatement("INSERT INTO accounts(name) VALUES(?)");
            pstmt2.setString(1, userInput);
            pstmt2.executeUpdate();
            System.out.println("Username " + userInput + " has been registered.");
    }  else {
            System.out.println("Username " + userInput + " already exists.");
    }

} catch(SQLException sqlexe) {
    //add logging
} finally {
    if(pstmt1 != null)
       pstmt1.close();
    if(pstmt2 != null)
       pstmt2.close();
     if(rs != null)
       rs.close();
}