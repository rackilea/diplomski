String yourQuery = "SELECT * FROM phrases WHERE name = 'how to use windows 7'";
 PreparedStatement statement = connection.prepareStatement(yourQuery); 
 statement.setMaxRows(1); 
 ResultSet rs = statement.executeQuery();

 String[] arr = null;
 String name;
 while (rs.next()) {
   name = rs.getString(1); // Where 1 is column number.
 }

 arr = name.split(" "); // Split at space 
 // (e.g. "how to use windows 7" becomes "how", "to", "use", "windows", "7"
 System.out.println(arr[2]); // Output "use"
 String combined = Arrays.toString(arr); // "how, to, use, windows, 7"

 yourQuery = "UPDATE phrases SET name = '" + combined + "' WHERE COLUMN = how to use windows 7;"
 statement = connection.prepareStatement(updateStatement);
 int rowsAffected = statement.executeStatement();