stmt.execute("insert into employee(empName) values('something')",
    Statement.RETURN_GENERATED_KEYS);
ResultSet rs = stmt.getGeneratedKeys();
if (rs.next()) {
  return rs.getLong(1); // for example.
}