public class SQLUtils 
{
  private static Log log = LogFactory.getLog(SQLUtils.class);

  public static void closeQuietly(Connection connection)
  {
    try
    {
      if (connection != null)
      {
        connection.close();
      }
    }
    catch (SQLExcetpion e)
    {
      log.error("An error occurred closing connection.", e);
    }
  }

  public static void closeQuietly(Statement statement)
  {
    try
    {
      if (statement!= null)
      {
        statement.close();
      }
    }
    catch (SQLExcetpion e)
    {
      log.error("An error occurred closing statement.", e);
    }
  }

  public static void closeQuietly(ResultSet resultSet)
  {
    try
    {
      if (resultSet!= null)
      {
        resultSet.close();
      }
    }
    catch (SQLExcetpion e)
    {
      log.error("An error occurred closing result set.", e);
    }
  }
}