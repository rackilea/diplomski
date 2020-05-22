public int execute(String script, Object... values) throws Exception {
    try (Connection con = datasource.getConnection();
            PreparedStatement statment = con.prepareStatement(script)) {

        for (int i = 1; i <= values.length; i++)
        {
            statement.setObject(i, values[i - 1]);
        }

        return statement.executeUpdate();
    } catch (SQLException ex) {
        // handleException
    }
}