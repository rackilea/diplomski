import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.jdbc.pool.AbandonedConnectionHandler;
import org.apache.tomcat.jdbc.pool.PoolConfiguration;


public class ConnectionHandler implements AbandonedConnectionHandler{

    private static final Log log = LogFactory.getLog(ConnectionHandler.class);

    private Boolean isAllowedToKill;    
    private PoolConfiguration poolProperties;

    public ConnectionHandler(Boolean isAllowedToKill)
    {
        this.isAllowedToKill = isAllowedToKill;
    }

    @Override
    public void handleQuery(Long connectionId) {
        Connection conn = null;
        Statement stmt = null;
        if(this.isAllowedToKill)
        {
            try{

                Class.forName(poolProperties.getDriverClassName());
                conn = DriverManager.getConnection(poolProperties.getUrl(),poolProperties.getUsername(),poolProperties.getPassword());

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery("SELECT ID, INFO, USER, TIME FROM information_schema.PROCESSLIST WHERE ID=" + connectionId);

                if(result.next())
                {   
                    if(isFetchQuery(result.getString(2)))
                    {
                        statement.execute("Kill "+connectionId);
                    }

                }
                statement.close();
                conn.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                try {
                    if(stmt != null && !stmt.isClosed())
                    stmt.close();
                } catch (SQLException e) {
                    log.warn("Exception while closing Statement ");
                }
                try {
                    if(conn != null && !conn.isClosed() )
                    conn.close();
                } catch (SQLException e) {
                    log.warn("Exception while closing Connection ");
                }
            }
        }
    }
    private Boolean isFetchQuery(String query)
    {
        if(query == null)
        {
            return true;
        }
        query = query.trim();
        return "SELECT".equalsIgnoreCase(query.substring(0, query.indexOf(' '))); 
    }

    public PoolConfiguration getPoolProperties() {
        return poolProperties;
    }
    public void setPoolProperties(PoolConfiguration poolProperties) {
        this.poolProperties = poolProperties;
    }

}