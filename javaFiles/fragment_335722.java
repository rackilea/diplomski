public String getOutputCode() throws SQLException {
    String code;
    do {
        code = new String(RandomCode.generateCode(minLen, maxLen, noOfCAPSAlpha, noOfDigits));
    }
    while(licenceKeyExists(code));
    return code;
}
private boolean licenceKeyExists(String code) throws SQLException {
    try{
        DB_Connection connect = new DB_Connection();
        connection = connect.getDBConnection();
        statement = connection.createStatement();
        rs = statement.executeQuery("SELECT licenseKey FROM hospital WHERE licenseKey = '" +code+ "'");
        return rs.next();
    }
    finally {
        try {
            connection.close();
        } catch (SQLException ignored){}
    }
}