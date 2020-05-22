public class MyDataAccessObject {

    private final String getAllPersonsQuery = "SELECT persons FROM personTable";
    private PreparedStatement psGetAllPersonsQuery;

    private final String addPersonQuery = "INSERT INTO personTable (personName) VALUES (?)"; // ? is a placeholder. Using PreparedStatement and ?'s, adds more safety and performance.
    private PreparedStatement psAddPersonQuery;

    private Connection conn;

    private final String connectionString;
    private final String username;
    private final String password;

    public MyDataAccessObject(String connectionString, String username, String password) {
        this.connectionString =  connectionString;
        this.username = username;
        this.password = password;
    }

    public void init() throws SQLException {
        conn = DriverManager.getConnection(connectionString, username, password); // no longer required to register driver if using modern JDBC drivers.
        psGetAllPersonsQuery = conn.prepareStatement(getAllPersonsQuery);
        psAddPersonQuery = conn.prepareStatement(addPersonQuery); // we register these now, so it's fast to use later.
    }

    public void shutdown() throws SQLException {
        if (conn != null) {
            conn.close(); // this will close everything used ontop of this connection, including PreparedStatement's, and ResultSets, if still open.
        }
    }

    public List<Person> getAllPersons() throws SQLException {
        if (conn == null) {
            // try to re-open connection
            init();
        }
        ResultSet rs = psGetAllPersonsQuery.execute();
        List<Person> list = new ArrayList<Person>();
        while (rs.next()) {
            list.add(new Person(rs.getString(1))); // not sure how your data is setup, this is returning the first (1) column from the resultset
        }
        if (rs != null) {
            rs.close();
        }
        return list;
    } // don't close the prepareStatement!

    public void addPerson(Person person) throws SQLException {
        if (conn == null) {
            // try to re-open connection
            init();
        }
        psAddPersonQuery.setString(1, person.getName()); // or however you're storing the data. The 1 is saying replace the first ? with whatever data you specify after the comma.
        psAddPersonQuery.executeUpdate(); // executeUpdate() returns an int, which says how many rows were modified. Since you're inserting here, we probably don't care.
    } // don't close the prepareStatement!

}