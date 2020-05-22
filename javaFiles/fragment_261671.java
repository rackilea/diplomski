PreparedStatement psInsert = c1.prepareStatement("insert into table1 values (?,?,?)");
while (rs.next()) {
    psInsert.setInt(1, rs.getInt(1));
    psInsert.setString(2, rs.getString(2));
    psInsert.setString(2,rs.getString(3));

    psInsert.execute();
}