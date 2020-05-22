import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <dependency>
 * <groupId>com.jolbox</groupId>
 * <artifactId>bonecp</artifactId>
 * <version>0.8.0.RELEASE</version>
 * </dependency>
 */
public class BoneCPexample {

    public static final int TOTAL_CONNECTIONS_TO_DATABASE = 20;

    public static void main(String[] args) throws SQLException {
        BoneCPexample boneCPexample = new BoneCPexample();
        boneCPexample.doTheWork();
    }

    private void doTheWork() throws SQLException {


        String jdbcUrlString = "jdbc:postgresql://localhost/test_database";  // jdbc:postgresql://host:port/database
        BoneCPConfig bcpConfig = new BoneCPConfig();
        bcpConfig.setJdbcUrl(jdbcUrlString);
        bcpConfig.setUsername("postgres");
        bcpConfig.setPassword("mi-password");
        bcpConfig.setPartitionCount(1);
        bcpConfig.setMinConnectionsPerPartition(TOTAL_CONNECTIONS_TO_DATABASE);
        bcpConfig.setMaxConnectionsPerPartition(TOTAL_CONNECTIONS_TO_DATABASE);
        bcpConfig.setConnectionTimeoutInMs(1 * 1000);
        bcpConfig.setDefaultAutoCommit(false);
        bcpConfig.setConnectionTestStatement("select now()");
        bcpConfig.setIdleConnectionTestPeriodInMinutes(5);


        BoneCP boneCP = new BoneCP(bcpConfig);
        Connection connection = boneCP.getConnection();

        Statement statement = connection.createStatement();
        statement.execute("select * from mytable");

    }
}