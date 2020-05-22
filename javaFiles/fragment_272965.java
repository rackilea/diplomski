package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dao {
    private static Connection con;
    public static Connection getcon(){
        try{
            String instanceConnectionName = "edu-vitae1";
            String databaseName = "eduvitae";
             String username = <USER>;
             String password = <PASSWORD>;
             Class.forName("com.mysql.jdbc.Driver");
             String jdbcUrl = String.format(
             "jdbc:mysql://google/eduvitae?cloudSqlInstance=edu-vitae-211606:asia-south1:edu-vitae1&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=<USER>&password=<PASSWORD>;&useSSL=false",
             databaseName,
            instanceConnectionName);
             con = DriverManager.getConnection(jdbcUrl, username, password);
            //Connection con=DriverManager.getConnection("jdbc:mysql://google/eduvitae?cloudSqlInstance=edu-vitae-211606:asia-south1:edu-vitae1&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=<USER>&password=<PASSWORD>;");
             //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edu",<USER>,<PASSWORD>;);
             //String url= String.format("jdbc:mysql://35.200.134.221:3306/edu-vitae-211606:asia-south1:edu-vitae1");
             //Connection con= DriverManager.getConnection(url, <USER>,<PASSWORD>;);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}