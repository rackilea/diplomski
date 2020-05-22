PreparedStatement ps2 = con.prepareStatement("SELECT * FROM authors WHERE id = ?");
ps2.setInt(1, id);
ResultSet my_rs = ps2.executeQuery();

while (my_rs.next()) {
    System.out.println(my_rs.getString("name"));
}