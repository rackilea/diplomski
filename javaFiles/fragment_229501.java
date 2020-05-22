package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public interface StatementUser<T> {
        T run(Statement cmd);
    }

    public static <T> T runStatement(StatementUser<T> usingfunc) {
        try(Connection cnn = getConnection()){
            try(Statement stmt = cnn.createStatement()){
                return usingfunc.run(stmt);
            }
        } catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Connection getConnection() throws SQLException {
        return ...; // someway to acquire a connection
    }

    public static void main(String[] args) {
        int affected = DB.runStatement(cmd -> {
            // do something with the statement
            return 10;
        });
        System.out.println(affected);
    }
}