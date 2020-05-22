PreparedStatement ps = c.prepareStatement("INSERT INTO MY_TABLE VALUES (?, ?)");
for(MyElement e : myList) {
    ps.setString(1, e.getString());
    ps.setInt(2, e.getInt());
    ps.addBatch();
}
ps.executeBatch();