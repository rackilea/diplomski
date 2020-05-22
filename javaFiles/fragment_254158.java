package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "user", "password");

        CallableStatement callableStatement = connection.prepareCall("SELECT * FROM db WHERE user = ?");
        callableStatement.setString(1, "deployer");
        ResultSet resultSet = callableStatement.executeQuery();

        while(resultSet.next()) {
            System.out.println(resultSet.getString("Db"));
        }

        connection.close();
    }
}