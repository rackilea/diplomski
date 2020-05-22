Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM table1 WHERE attribute1 IN (SELECT attribute1 FROM table2 WHERE attribute2 = c)");
List<String> attr = new ArrayList<String>();

while (rs.next()) {
    attr.add(rs.getString("attribute1"));
}