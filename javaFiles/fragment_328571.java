package com.peoplewalking.psql.demo;

public class MainDemo {

    public static void main(String[] args) {
        String host = "localhost";
        String port = "5432";
        String user = "postgres";
        String pass = "postgres";
        String database = "your_database_name";
        PostgreSQLConnection psqlc = new PostgreSQLConnection(host, port, user, pass, database);
        String prettyConsoleOutput = psqlc.getResults("SELECT Id, Name FROM Person");
        System.out.println(prettyConsoleOutput);
    }
}