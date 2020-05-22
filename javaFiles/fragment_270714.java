...
ResultSet rs=stmt.executeQuery("SELECT * FROM contacts");

while(rs.next()) {
    System.out.println(rs.getString("name"));
}