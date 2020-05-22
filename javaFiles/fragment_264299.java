Connection connection = //obtain a connection
try {
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.SQL_SERVER, connection);
    UserDAO userDAO = daoFactory.getUserDAO();
    // etc
} finally {
    connection.close();
}