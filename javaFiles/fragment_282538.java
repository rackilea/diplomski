protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/plain");
    response.setHeader("Content-Disposition", "attachment;filename=numbers.txt"); // Force download popup.

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    Writer writer = response.getWriter();

    try {
        connection = database.getConnection();
        statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        statement.setFetchSize(Integer.MIN_VALUE);
        resultSet = statement.executeQuery("SELECT number FROM phonenumbers");

        while (resultSet.next()) {
            writer.write(resultSet.getString("number"));
            if (!resultSet.isLast()) {
                writer.write(",");
            }
        }
    } catch (SQLException e) {
        throw new ServletException("Query failed!", e);
    } finally { 
        if (resultSet != null) try { resultSet.close; } catch (SQLException logOrIgnore) {}
        if (statement != null) try { statement.close; } catch (SQLException logOrIgnore) {}
        if (connection != null) try { connection.close; } catch (SQLException logOrIgnore) {}
    }
}