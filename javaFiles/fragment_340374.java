package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class SQLiteTest {

public static void main(String[] args) throws SQLException,
        ClassNotFoundException {
    Class.forName("org.sqlite.JDBC");
    Connection connection = DriverManager
            .getConnection("jdbc:sqlite:test.db");
    Statement statement = connection.createStatement();
    createTable(statement);
    insertBlob(connection);
    byte[] bytes = query(statement);
    System.out.println(Arrays.toString(bytes));
            statement.close();
    connection.close();
}

private static void createTable(Statement statement) throws SQLException {
    statement.execute("CREATE TABLE test (data BLOB)");
}

private static void insertBlob(Connection connection) throws SQLException {
    PreparedStatement pStatement = connection
            .prepareStatement("INSERT INTO test VALUES (?)");
    pStatement.setBytes(1, new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
    pStatement.execute();
    pStatement.close();
}

private static byte[] query(Statement statement) throws SQLException {
    ResultSet rs = statement.executeQuery("SELECT data FROM test");
    byte[] bytes = rs.getBytes(1);
    return bytes;
}

}