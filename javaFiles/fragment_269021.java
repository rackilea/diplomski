DataSource dataSource = null;
try
{
    Context context = new InitialContext();
    dataSource = (DataSource) context.lookup("Database");
}
catch (NamingException e)
{
    // Couldn't find the data source: give up
}