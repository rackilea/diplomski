String call = "{ ? = call pkg_test1.get_object_type(?,?,?)}";
CallableStatement cstmt = con.dbstate().prepareCall(call);
 cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
cstmt.setString(2, buffer);
cstmt.registerOutParameter(3, oracle.jdbc.OracleTypes.NUMBER);
cstmt.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
cstmt.executeQuery();
String type = cstmt.getString(1);