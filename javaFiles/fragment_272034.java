import static org.eclipse.persistence.jpa.config.PersistenceUnitProperties.*;

Map properties = new HashMap();

// Configure the internal EclipseLink connection pool
properties.put(JDBC_DRIVER, "oracle.jdbc.OracleDriver");
properties.put(JDBC_URL, "jdbc:oracle:thin:@localhost:1521:ORCL");
properties.put(JDBC_USER, "user-name");
properties.put(JDBC_PASSWORD, "password");
Persistence.createEntityManagerFactory("unit-name", properties);