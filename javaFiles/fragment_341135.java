public static Connection connect()
{
    try
    {
        Class.forName("com.mysql.jdbc.Driver");   
        return DriverManager.getConnection(domain, username, password);
    }

    catch (Exception e)
    {
        logger.error("Exception occured: "+ e.getMessage());
        return null;
    }
}