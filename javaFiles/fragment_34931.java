Class.forName("org.h2.Driver");
Connection connection = DriverManager.getConnection("jdbc:h2:mem:test-database-name");

// create table, insert data, query for data ...
connection.prepareStatement("CREATE TABLE cars (id INTEGER AUTO_INCREMENT NOT NULL, name CHAR(20));").execute();
connection.prepareStatement("INSERT INTO cars values (null, 'Volkswagen');").execute();
connection.prepareStatement("INSERT INTO cars values (null, 'Audi');").execute();

ResultSet rs = connection.prepareStatement("SELECT * FROM cars").executeQuery();
while (rs.next()) {
    System.out.println(rs.getInt(1) + " | " + rs.getString(2));
}