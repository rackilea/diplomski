String query = "select foo, bar, baz, wibble, whomp from myObject_table where pk_field = someKey";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
rs.next();
rs.get("foo");
rs.get("bar");