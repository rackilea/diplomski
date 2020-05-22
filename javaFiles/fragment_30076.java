Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","scott","tiger");
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
if( rs.next()){
    // print column names
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount(); 
    for(int i=1; i<= columnCount; i++)
        System.out.print(rsmd.getColumnName(i) + "\t");
    System.out.println();
    // print rows
    do {
        for( int i=1; i<=columnCount; i++)
            System.out.print( rs.getString(i) + "\t");
        System.out.println();
    } while(rs.next());
}
conn.close();