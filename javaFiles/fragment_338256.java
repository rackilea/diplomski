connection = UserProfileDAO.getJDBCConnection();
String call = "{ CALL " + USER_SCHEMA + ".UNAVAILABLE_USER(?) }";

try (CallableStatement statement = connection.prepareCall(call)) {
    statement.setInt(1, Num_Off_Days);
    statement.execute();
} catch (SQLException e) {
    e.printStackTrace();
    // or throw something that can be handled 
    // by the code calling your DAO
    throw new RuntimeException(e); 
}