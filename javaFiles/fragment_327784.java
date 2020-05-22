package org.yi.happy.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepeatQuery {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        setupDatabase();

        System.out.println("opening database...");
        Connection connection = openConnection();
        connection.setAutoCommit(false);

        queryDatabase(connection);

        deleteRecords();

        queryDatabase(connection);

        connection.close();
    }

    private static Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/test", null,
                null);
    }

    private static void setupDatabase() throws SQLException {
        Connection conn = openConnection();

        System.out.println("doing insert on another connection...");
        PreparedStatement stmt = conn
                .prepareStatement("insert into strings(id, value) values(?, ?)");

        stmt.setInt(1, 1);
        stmt.setString(2, "test");
        stmt.execute();

        stmt.setInt(1, 2);
        stmt.setString(2, "data");
        stmt.execute();

        stmt.close();
        conn.close();
    }

    private static void deleteRecords() throws SQLException {
        Connection conn = openConnection();
        System.out.println("doing delete on another connection...");
        PreparedStatement stmt = conn.prepareStatement("delete from strings");
        stmt.execute();

        stmt.close();
        conn.close();
    }

    private static void queryDatabase(Connection connection)
            throws SQLException {
        System.out.println("doing query...");
        PreparedStatement ps = connection
                .prepareStatement("select id, value from strings");
        ResultSet dbResult = ps.executeQuery();

        while (dbResult.next()) {
            int id = dbResult.getInt(1);
            String value = dbResult.getString(2);
            System.out.println(id + " <=> " + value);
        }
    }
}