// tell the driver you want the generated keys
stmt =  c.prepareStatement("INSERT ... ", Statement.RETURN_GENERATED_KEYS);

stmt.executeBatch();

// now retrieve the generated keys
ResultSet rs = stmt.getGeneratedKeys();
while (rs.next()) {
 int id = rs.getInt(1);
 .. save the id somewhere or update the items list 
}