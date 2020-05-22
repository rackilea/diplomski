....
PreparedStatement ps = null;
try {
ps = connection.prepareStatement("INSERT INTO users (firstname, lastname) VALUES (?,?)");
ps.setString(1,firstNameString);
ps.setString(2,lastNameString);
int result = ps.executeUpdate();
...