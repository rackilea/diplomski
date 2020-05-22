public static class Queries
{
    public static String TopProduct = "SELECT TOP 1 ProductId FROM Products";

    public static PreparedStatement getTopNOfField(Connection connection, int number, String fieldName)
    {
        PreparedStatement statement = connection.prepareStatement("SELECT TOP ? ? FROM Products");
        statement.setInt(1, number);
        statement.setString(2, fieldName);

        return statement;
    }
}