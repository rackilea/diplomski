String templateQuery = "SELECT * FROM my_table WHERE col1 = ?";
PreparedStatement ps = con.prepareStatement(templateQuery);
for (int i = 0; i < data.length; i++) {
    ps.setString(i + 1, data[i]);
}
ResultSet rs = ps.executeQuery();