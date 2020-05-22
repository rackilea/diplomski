import java.sql.SQLException;
import javax.resource.ResourceException;   

public class Linking {

    public static void main(String[] args) {

        SQLException resW = new SQLException("blubb");
        ResourceException resX = new ResourceException("a message", resW);
        SQLException sqlExc = null;
        Throwable linkedExc = resX.getCause();

        // if linkedExc exception is a SQL Exception, assign it to sqlExc
        if (linkedExc instanceof SQLException) {
            sqlExc = (SQLException) linkedExc;
        }           
        if (sqlExc != null)
            sqlExc.printStackTrace();
    }    
}