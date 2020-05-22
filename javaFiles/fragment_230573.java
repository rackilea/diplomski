Connection conn = DriverManager.getConnection(".....", "...","..");
ps = conn.prepareStatement("select customer, id, 0 \"message\" from your_table");
ResultSet rs = ps.executeQuery();
while(rs.next()){
    System.out.printf("%s %s %s", rs.getString("id"), rs.getString("customer"), rs.getString("message"));
}