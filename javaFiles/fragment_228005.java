String sql = "insert into accommodation (type, name, price, description, username) ";
sql += "VALUES (?, ?, ?, ?, ?)";
String generatedColumns[] = { "ID" };
psParent = currentCon.prepareStatement(sql, generatedColumns);
psParent.setString(1, type);
psParent.setString(2, name);
psParent.setFloat(3, price);
psParent.setString(4, description);   // I ADDED THIS LINE
psParent.setString(5, username);
psParent.executeUpdate();