int a = 0, b = 0;

try {
    ResultSet rs = db.updateResult(query)

    if (rs.next()) { 
        a = rs.getInt("did");
        b = rs.getInt("bid");
    }
} 
catch (ClassNotFoundException | SQLException ex) {
    //blah blah
}