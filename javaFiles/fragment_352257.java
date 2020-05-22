// Load the driver.
Class.forName("org.relique.jdbc.csv.CsvDriver");

// Create a connection using the directory containing the file(s)
Connection conn = DriverManager.getConnection("jdbc:relique:csv:/path/to/files");

// Create a Statement object to execute the query with.
Statement stmt = conn.createStatement();

// Query the table. The name of the table is the name of the file without ".csv"
ResultSet results = stmt.executeQuery("SELECT col1, col2 FROM myfile");