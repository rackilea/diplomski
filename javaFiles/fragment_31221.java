public class DAOException extends RuntimeException {
    public DAOException(Throwable cause) {
        super(cause);
    }
}

public abstract class AbstractDAO {
    private static Logger logger = ...;
    private DataSource dataSource;

    protected void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException exception) {
            // There's nothing we can do
            throw new DAOException(exception);
        }
    }

    public void close(Connection connection) {
        try {
            connection.close();
        } catch (Exception exception) {
            // Log the exception
            logger.log("Failed to close Connection", exception);
        }
    }

    public void close(Statement statement) {
        try {
            statement.close();
        } catch (Exception exception) {
            // Log the exception
            logger.log("Failed to close Statement", exception);
        }
    }

    public void close(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (Exception exception) {
            // Log the exception
            logger.log("Failed to close ResultSet", exception);
        }
    }
}

public class MyDAO extends AbstractDAO {
    @Override
    @Resource("jdbc/myDS")
    protected void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public void insert(MyObject myObject) {
        Connection connection = getConnection();
        try {
            PreparedStatement query = connection.createPreparedStatement("INSERT INTO MYOBJECT (ID, VALUE) VALUES (?, ?)");
            try {
                query.setLong(1, myObject.getID());
                query.setString(2, myObject.getValue());
                if (query.executeUpdate() != 1) {
                    throw new DAOException("ExecuteUpdate did not return expected result");
                }
            } finally {
                close(query);
            }
        } catch (SQLException exception) {
            // There's nothing we can do
            throw new DAOException(exception);
        } finally {
            close(connection);
        }
    }
}