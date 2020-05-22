import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
......
Context initContext = new InitialContext();
Context envContext = (Context) initContext.lookup("java:comp/env");
DataSource ds = (DataSource) envContext.lookup("jdbc/Database");
conn = ds.getConnection();