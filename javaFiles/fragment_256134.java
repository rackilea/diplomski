public static final String SOME_NAME = "{call   schema_name.org_name_pkg.return_something(?,?)}"; // Change the schema name,packagename,and procedure name.

// Simple JDBC Connection Pooling
// Here I am passing param companyId which is IN param to stored procedure which will return me some value.

Connection conn = null;
CallableStatement stmt = null;
ResultSet rset = null;

try {
        conn = DriverManager.getConnection("jdbc:mysql://hostname:port/dbname","username", "password");
        stmt = conn.prepareCall(SOME_NAME);//We have declared this at the very top
        stmt.setString(1, companyid);//Passing CompanyID here
        stmt.registerOutParameter(2, OracleTypes.CURSOR);//Refcursor selects the row based upon query results provided in Package.
        stmt.execute();
        rset = (ResultSet) stmt.getObject(2);

        while (rset.next()) {
            String orgId=rset.getString("RPT_ORG_ID"); 
            // When using refcursor easy to get the value just by using Column name     
            String orgName=rset.getString("RPT_ORG_NAME");    
            // Some Logic based what do you want to do with the data returned back from query
} catch (Exception e) {
        LOGGER.error("Error extracting ", e);
} finally {
        DBUtils.cleanUp(conn, stmt, rset);
}

// Clean and close you connection