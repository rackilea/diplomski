DataSource ds = (DataSource)envCtx.lookup(jndiName);
conn = ds.getConnection();
if (conn instanceof org.apache.commons.dbcp.DelegatingConnection) { 
   log.debug("detected apache commons dbcp datasource");          
   conn = ((org.apache.commons.dbcp.DelegatingConnection)conn).getInnermostDelegate();      
}