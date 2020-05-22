client.getConnection(connection -> {
if (connection.succeeded()) {
  System.out.println(" Database connection Successful - 1 ");
  SQLConnection sqlConnection = connection.result();
  System.out.println(" Database connection Successful - 2 " + sqlConnection.toString());

  // SP works without a return value
  sqlConnection.callWithParams("{CALL SYSPROC.F1COR008(?,?,?,?,?,?,?,?)}",
    new JsonArray().add("01")
      .add(3154)
      .add("EN")
      .add("EML")
      .add("91")
      .addNull()
      .addNull()
      .addNull(), new JsonArray().addNull()
      .addNull()
      .addNull()
      .addNull()
      .addNull()
      .add("CHAR")
      .add("CHAR")
      .add("CHAR"), handler -> {
      if (handler.succeeded()) {
        // System.out.println(" Database handler Successful ");
        ResultSet resultSet = handler.result();
        System.out.println(
          " Database handler Successful - 3 " + resultSet.getRows().get(0));
      }
    });
}