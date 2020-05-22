Connection con = null;
PreparedStatement stmt = null;

try {
    byte[] b = getFunction();
    con = ...;
    stmt = con.prepareStatement("update table set features=?");
    stmt.setBytes(1, b);
    stmt.executeUpdate();

    con.commit();
}
catch (SQLException e) {
    //handle exception (consider con.rollback()) and con maybe null here)
}
finally {
    //close stmt and at least con here (all maybe null here)
}