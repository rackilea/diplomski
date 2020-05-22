// check if product code exists in database
try(Statement statement = connection.createStatement();
    ResultSet rs = statement.executeQuery(
        "SELECT * FROM Products WHERE ProductCode = '" + p.getCode() + "'")){
if (rs.next()) {
   System.out.println("Error: This product is already in the database!");
   return;
}