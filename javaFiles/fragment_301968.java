/**
 * SQL utility methods
 * User: MDUFFY
 * Date: 5/31/2016
 * Time: 4:41 PM
 * @link http://stackoverflow.com/questions/37536372/connect-intellij-idea-to-sql-server-database/37536406?noredirect=1#comment62595302_37536406
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLMethods {

    public static final String DEFAULT_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DEFAULT_URL = "jdbc:sqlserver://localhost:1433;databaseName=CaiMaster";
    private static final String DEFAULT_USERNAME = "";
    private static final String DEFAULT_PASSWORD = "";
    public static final String FIND_ALL_CUSTOMERS_QUERY = "SELECT Fname, Address FROM Customers ";
    private static final String BY_FIRST_NAME = "WHERE FNAME = ? ";


    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = SQLMethods.getConnection(DEFAULT_DRIVER_CLASS, DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
            Customer customer = SQLMethods.findCustomer(connection, "Cai");
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SQLMethods.close(connection);
        }
    }

    public static Connection getConnection(String driverClass, String url, String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClass);
        return DriverManager.getConnection(url, username, password);
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Customer findCustomer(Connection connection, String name) {
        Customer customer = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(FIND_ALL_CUSTOMERS_QUERY + BY_FIRST_NAME);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("Fname");
                String address = rs.getString("Address");
                customer = new Customer(address, firstName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLMethods.close(rs);
            SQLMethods.close(ps);
        }
        return customer;
    }
}

class Customer {
    private final String firstName;
    private final String address;

    public Customer(String address, String firstName) {
        this.address = address;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}