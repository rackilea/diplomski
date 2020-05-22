import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class JdbcDriverTest3 {
    public static void main(String args[]) {

        //Class driverClass = Class.forName("oracle.jdbc.OracleDriver");
        //DriverManager.registerDriver((Driver) driverClass.newInstance());

        Enumeration<Driver> e = DriverManager.getDrivers();

        while(e.hasMoreElements()){

            Driver d = e.nextElement();
            System.out.println(d.getClass());
            System.out.println(d.getClass().getName());

        }
    }
}