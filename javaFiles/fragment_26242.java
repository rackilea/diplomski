package application;

import dataBase.DataBaseDAO;
import dataBase.MySQLDataBaseDAO;
import establishConnection.DataBaseConnection;

public class App {
    public static void main(String[] args) {
        DataBaseConnection connection = new DataBaseConnection();
        DataBaseDAO databaseDao = new MySQLDataBaseDAO(connection);
    }
}