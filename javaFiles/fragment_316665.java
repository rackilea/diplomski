Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "...", "******");

Statement stmt = con.createStatement();

String create =
  "create function the_answer() \n" +
  "returns integer as $$\n" +
  "begin \n" +
  "   return 42;\n" +
  "end;\n" +
  "$$\n" +
  "language plpgsql;";

// create the function
stmt.execute(create);

// use the function
ResultSet rs = stmt.executeQuery("select the_answer()");
rs.next();
System.out.println("The answer is: " + rs.getInt(1));