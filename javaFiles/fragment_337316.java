public class CqlJdbcTestBasic {
public static void main(String[] args) {
    Connection con = null;
    try {
        Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
        con = DriverManager.getConnection("jdbc:cassandra:root/root@localhost:9160/MyKeyspace");

        String query = "SELECT KEY, 'first', last FROM User WHERE age=42";

        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(query);

        while (result.next()) {
            System.out.println(result.getString("KEY"));
            System.out.println(result.getString("first"));
            System.out.println(result.getString("last"));
        }

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            con = null;
        }
    }
}
}