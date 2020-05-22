package dataBase;

import establishConnection.DataBaseConnection;

public class MySQLDataBaseDAO extends DataBaseDAO {
    private DataBaseConnection connection;

    public MySQLDataBaseDAO(DataBaseConnection connection) {
        this.connection = connection;
    }

    public void insert(Person person) { }

    public void find(Person person) { }
}