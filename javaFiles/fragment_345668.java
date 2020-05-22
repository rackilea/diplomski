import java.sql.*;
import java.util.function.BiConsumer;

public class Factory {

    public static ClosableResultSet createResultSet(String sql) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:C:/myDB", "sa", "sa");

        return new ClosableResultSet(conn, sql);
    }

    public static ClosableResultSet createResultSet(String sql, BiConsumer<SQLException, String> handler) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:C:/myDB", "sa", "sa");

        return new ClosableResultSet(conn, sql) {
            @Override
            public void handleError(SQLException e, String action) {
                handler.accept(e, action);
            }
        };
    }
}