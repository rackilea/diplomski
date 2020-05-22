import org.apache.ddlutils.Platform;
import java.sql.Connection;
import org.apache.ddlutils.model.Database;

Platform platform = PlatformFactory.createNewPlatformInstance(HSQLDB_JDBC_DRIVER, HSQLDB_JDBC_URL);
Database database = jdbcModelReader.getDatabase(hsqldbConnection, null);
platform.dropTables(database, true);