String QUERY = "INSERT INTO students "+
               "  VALUES (student_seq.NEXTVAL,"+
               "         'Harry', 'harry@hogwarts.edu', '31-July-1980')";

// load oracle driver
Class.forName("oracle.jdbc.driver.OracleDriver");

// get database connection from connection string
Connection connection = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:sample", "scott", "tiger");

// prepare statement to execute insert query
// note the 2nd argument passed to prepareStatement() method
// pass name of primary key column, in this case student_id is
// generated from sequence
PreparedStatement ps = connection.prepareStatement(QUERY,
        new String[] { "student_id" });

// local variable to hold auto generated student id
Long studentId = null;

// execute the insert statement, if success get the primary key value
if (ps.executeUpdate() > 0) {

    // getGeneratedKeys() returns result set of keys that were auto
    // generated
    // in our case student_id column
    ResultSet generatedKeys = ps.getGeneratedKeys();

    // if resultset has data, get the primary key value
    // of last inserted record
    if (null != generatedKeys && generatedKeys.next()) {

        // voila! we got student id which was generated from sequence
        studentId = generatedKeys.getLong(1);
    }

}