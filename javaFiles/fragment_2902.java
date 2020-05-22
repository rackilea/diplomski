String sql = "INSERT INTO student (studentid, titleid, forename, familyname, dateofbirth) "
                    + "VALUES (?, ?, ?, ?, ?);";
ps = connection.prepareStatement(SQL_INSERT);
for (int i = 0; i < entities.size(); i++) {
    ps.setString(1, entity.get...());
    ...
    ps.addBatch();
}
ps.executeBatch();