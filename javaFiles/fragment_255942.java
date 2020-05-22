// load driver
Connection con = DriverManager.getConnection(..);
Statement stmt = con.createStatement();
ResultSet result = stmt.executeQuery("select ..");
// do something with result ... or not
ResultSet result2 = stmt.executeQuery("select ...");
// result is now closed, you cannot read from it anymore
// do something with result2
stmt.close(); // will close the resultset bound to it