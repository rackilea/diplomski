void aMethod() throws CustomDbException {
    try {
        // code that throws SQLException
    }
    catch(SQLException ex) {
        throw new CustomDbException();
    }
}