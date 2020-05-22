public static String tipsMade(String date1, String date2){
Connection c = null;
Statement stmt = null;
ResultSet rs = null;
String ans= null;
int sum = 0;
try {
    Class.forName("org.sqlite.JDBC");
    c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Gil\\test.db");
    c.setAutoCommit(false);
    System.out.println("Opened database successfully");
    stmt = c.createStatement();
    rs = stmt.executeQuery("select sum(tips) from shifts where fulldate between "+"'"+date1+"'"+"and " +"'"+date2+"'"+ ";");
    while(rs.next()){
        sum = rs.getInt("sum(tips)");
    }
    ans = Integer.toString(sum);
    //

    //close connections and etc
    stmt.close();
    c.commit();
    c.close();

} catch ( Exception e ) {
    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    System.exit(0);
}
return ans;
}