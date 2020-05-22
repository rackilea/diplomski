import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MySQLDatabaseDemo {

   Connection conn = null;
   PreparedStatement preparedStatement = null;

   public static Connection getConnection() throws Exception {
      String driver = "org.gjt.mm.mysql.Driver";
      String url = "jdbc:mysql://localhost/databaseName";
      String username = "root";
      String password = "root";
      Class.forName(driver);
      Connection conn = DriverManager.getConnection(url, username, 
                                                    password);
      return conn;
   }

   /**
    * @param args [0] = value of "id"
    *             [1] = value of "name"
    *             [2] = value of "time_from"
    */
   public void insertRowWithTimeDatatype(String[] args) {

      String query = "insert into my_table (id, name, timefrom) " + 
                                   "values (?, ?, ?)";      

      DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
      Date date = sdf.parse(args[2]);
      Time time = new Time(date.getTime());

      try {
         conn = getConnection();  // getConnection() is YOUR method

         preparedStatement = conn.prepareStatement(query);

         preparedStatement.setInt(1, Integer.parseInt(args[0]));
         preparedStatement.setString(2, args[1]);
         preparedStatement.setTime(3, time);

         // Execute statement and return the number of rows affected
         int rowCount = preparedStatement.executeUpdate();
         System.out.println("Number of rows affected: " + rowCount);
      } finally {
         preparedStatement.close();
         conn.close();
      }
   }
}