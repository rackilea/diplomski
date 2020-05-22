Session session = (Session) em.getDelegate(); // hibernate session
session.doWork(new Work()
{
    @Override
    public void execute(Connection connection) throws SQLException
    {
        try
        {
            String QUERY_STATEMENT = "SELECT * FROM Table1 WHERE ID= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_STATEMENT);
            preparedStatement.setLong(1, new Long(123123));
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                String fileName = rs.getString("FILE_NAME");
                FileOutputStream outStream = new FileOutputStream(location + fileName);
                InputStream inStream = rs.getBinaryStream("CONTENT");
                try
                {
                    IOUtils.copy(inStream, outStream);
                }
                catch (Exception exc)
                {
                    exc.printStackTrace();
                }
                finally
                {
                    IOUtils.closeQuietly(outStream);
                    IOUtils.closeQuietly(inStream);
                }
            }
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
});