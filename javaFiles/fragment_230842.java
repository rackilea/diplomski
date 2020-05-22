try
{
    Class.forName("org.sqlite.JDBC");
    c = DriverManager.getConnection("jdbc:sqlite:lineappDB.db");
    c.setAutoCommit(false);
    System.out.println("Opened database successfully");
    stmt = c.createStatement();
    String query = String.format("SELECT * FROM VIDEOS");

    result = new Object[6];
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next())
    {
        result[0] = rs.getInt(1);
        result[1] = rs.getString(2);
        result[2] = rs.getString(3);
        result[3] = rs.getString(4);
        result[4] = rs.getString(5);
        result[5] = rs.getInt(6);
    }
} 
/* catch and finally snipped for clarity of the answer */