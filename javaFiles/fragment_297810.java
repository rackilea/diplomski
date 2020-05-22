package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dao {
    private static Connection con;
    public static Connection getcon(){
        try{
            String instanceConnectionName = "edu-vitae1";
            String databaseName = "eduvitae";
             String username = "root";
             String password = "root";
             Class.forName("com.mysql.jdbc.Driver");
             String jdbcUrl = String.format(
                     "jdbc:mysql://google/eduvitae?cloudSqlInstance=edu-vitae1&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=root&password=root&useSSL=false",
                  databaseName,
                   instanceConnectionName);
                    Connection con = DriverManager.getConnection(jdbcUrl, username, password);
             //con=DriverManager.getConnection("jdbc:mysql://35.200.134.221/edu","root","root");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

}