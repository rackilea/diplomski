...
PreparedStatement preparedStmt = con1.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
preparedStmt.setString (1, txtproduct.getText());
preparedStmt.setString (2, txtprice.getText());

preparedStmt.executeUpdate();
ResultSet generatedKeyResult = preparedStmt.getGeneratedKeys();

if (generatedKeyResult.next()) {
    lastinsertid = generatedKeyResult.getInt(1);
}
System.out.println("Inserted record's ID: " + lastinsertid);
...