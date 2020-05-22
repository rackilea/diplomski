public Connection openConnection(String driver, String url, String dbName, String dbUsername, String dbPassword)
{
    try
    {
        Class.forName(driver);
    }
    catch (ClassNotFoundException e)
    {
            System.out.println("Could not load the driver");
    }

    try
    {
        connect = DriverManager.getConnection((url), dbUsername, dbPassword);
    }
    catch(Exception lex)
    {
        lex.printStackTrace();
    }

    return connect;
}