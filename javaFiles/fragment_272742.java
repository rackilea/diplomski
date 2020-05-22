...
Connection tconn=null;
OracleConnection conn=null;
Context initCtx = new InitialContext(); 
Context envCtx = (Context) initCtx.lookup("java:comp/env");
DataSource ds = (DataSource) envCtx.lookup("jdbc/myPool");
tconn = ds.getConnection();
// the following line is needed to unwrap to OracleConnection
conn= tconn.unwrap(OracleConnection.class);
tconn.close();
...