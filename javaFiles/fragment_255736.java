public boolean column_exist(String att) {
    boolean succes = false;
    CreerConnection con = new CreerConnection();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultat = null;
    try {
        connection = con.getConnection();

        statement = connection.prepareStatement("SELECT * \n"
                + "FROM information_schema.COLUMNS "
                + " WHERE"
                + " TABLE_SCHEMA = 'db_name'"
                + " AND TABLE_NAME = 'table_name'"
                + " AND COLUMN_NAME = ?");
        statement.setString(1, att);
        resultat = statement.executeQuery();

        if (resultat.next()) {
            succes = true;
        }

    } catch (SQLException e) {
        System.out.println("Exception = " + e);
    } finally {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
            }
        }
    }
    return succes;
}