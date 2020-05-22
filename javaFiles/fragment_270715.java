...
ResultSet rs=stmt.executeQuery("SELECT * FROM contacts");

if(rs.next()) {
    System.out.println(rs.getString("name"));
}