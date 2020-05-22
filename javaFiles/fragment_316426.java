import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CasandarConnect {

public static void main(String[] args) {
    String serverIP = "127.0.0.1";
    String keyspace = "mykeyspace";

    Cluster cluster = Cluster.builder()
      .addContactPoints(serverIP)
      .build();

    Session session = cluster.connect(keyspace);

    String cqlStatement = "INSERT INTO users JSON '{\"id\":888 , \"age\":21 ,\"state\":\"TX\"}'";
    session.execute(cqlStatement);
   }

}