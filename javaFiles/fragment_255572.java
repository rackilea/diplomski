String query = "SELECT name FROM mytable";
ResultSet rs = stmt.executeQuery(query);
int johnCount = 0;
while (rs.next()) {
    String name = rs.getString("name");
    if ("john".equalsIgnoreCase(name)) {
        johnCount++;
    }
}