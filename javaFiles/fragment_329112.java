import java.sql.DriverManager 
import java.sql.Driver
import java.sql.Connection 
import javax.sql.DataSource

object ScalaJdbcConnectSelect {
    def main(args: Array[String]) {
        val driver = "com.simba.spark.jdbc41.Driver"  //attach the Spark jar to the Classpath.
        val url = "jdbc:spark://field-eng.cloud.databricks.com:443/default;transportMode=http;ssl=true;httpPath=sql/protocolvl/o/0/0911-153027-hopes19";    
        val username = "token" 
        val password = "<token-value>" //Token generated from databricks profile page.
        var connection:Connection = null
        try {
        // Create the connection
            Class.forName(driver)
            connection = DriverManager.getConnection(url, username, password)
            if(connection != null){
                println("Connection Established");

            }
            else {
                println("Connection Failed");
            }
            // create the statement
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery("<<Query>") // Profile your query here.
            while ( resultSet.next() ) {
                // Iterate through Result set
            } 
        catch {
            case e => e.printStackTrace
        }
        connection.close()
    }
}