@Override
public void shutdown()
{
    if (statement != null)
    {
        try {
            statement.close();
        } catch (SQLException e) {
            LOGGER.error("", e);
        }
    }

    if (connection != null)
    {
        try {
            connection.commit(); // This statement fixed the problem
            connection.close();
        } catch (final SQLException e) {
            LOGGER.error("", e);
        }
    }
}