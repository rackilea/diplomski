String pro ="{? = call pro_insert(?,?,?)}";
CallableStatement callableStatement = dbConn.prepareCall(pro);
callableStatement.registerOutParameter(1, Types.Integer);
callableStatement.setString(2,"9600111");
callableStatement.setInt(3,1);
callableStatement.setInt(4,100);                       
callableStatement.execute();
int res = callableStatement.getInt(1);