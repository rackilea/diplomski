Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");   
con=DriverManager.getConnection("jdbc:sqlserver://sqldatabase:1009;
databaseName=DatabaseName;user=UserName;password=1234");
PreparedStatement ps=con.prepareStatement(QueryName);  
ResultSet rs=ps.executeQuery();
rs.next();
String val = rs.getString(1);
try (PrintWriter out = new PrintWriter(new File("Output.xml"))) {
    out.println(val);
}