Statement stmt = conn.createStatement();
stmt.execute(" <function definition from above goes here> ");
ResultSet rs = stmt.executeQuery("SELECT * FROM get_geom_difference();");
while (rs.next()) {
    // do something
}
rs.close();
stmt.close();