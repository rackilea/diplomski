import java.sql.Connection;
import java.sql.Statement;

//...

Connection connection = new getConnection();
Statement statement = connection.createStatement();

for (Employee employee: employees) {
    String query = "insert into employee (name, city) values('"
            + employee.getName() + "','" + employee.getCity + "')";
    statement.addBatch(query);
}
statement.executeBatch();
statement.close();
connection.close();