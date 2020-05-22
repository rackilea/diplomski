String query = "Insert into BigFile(text) values (?)";

try (
    Scanner s = new Scanner(new FileReader("tf1.txt"));
    Connection con = con = DriverManager.getConnection(...);
    PreparedStatement ps = con.prepareStatement(query);
){
    while (s.hasNextLine()) {
        String line = s.nextLine();
        if (line == null) continue;
        ps.setString(1, line);
        ps.addBatch();
    }
    ps.executeBatch();
} catch (SQLException sqle) {
    sqle.printStackTrace();
}