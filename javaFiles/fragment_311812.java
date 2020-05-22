Connection con = null;
 DataSource datasource = null;

 Context initialContext = new InitialContext();

 // "jdbc/MyDBname" >> is a JNDI Name of DataSource on weblogic

 datasource = (DataSource) initialContext.lookup("jdbc/MyDBname");

 con = datasource.getConnection();