package com.custsoft.client.ds;

import com.custsoft.client.ClientXrefHolder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.custsoft.Constants.CLIENT;

/**
 * Proxy data source that delegates to an actual JDBC data source. 
 * There is one target JDBC data source per client.
 * 
 * Created by eric on 9/29/15.
 */
@Component(property = {"osgi.jndi.service.name=jdbc/customation"},
        service = DataSource.class)
public class ClientDelegatingDataSource implements DataSource {

    private static final Logger logger = LoggerFactory.getLogger(ClientDelegatingDataSource.class);

    private String DEFAULT_CLIENT_XREF = "customation";

    private Map<String, DataSource> clientDataSources = new HashMap<>();

    @Reference(target = "(client=*)",
            cardinality = ReferenceCardinality.MULTIPLE,
            policy = ReferencePolicy.DYNAMIC)
    protected void addDataSource(DataSource dataSource, Map<String, Object> properties) {
        final String clientId = getClientId(properties);
        clientDataSources.put(clientId, dataSource);
    }

    protected void removeDataSource(DataSource dataSource, Map<String, Object> properties) {
        final String clientId = getClientId(properties);
        clientDataSources.remove(clientId);
    }

    private String getClientId(Map<String, Object> properties) {
        return Objects.toString(properties.get(CLIENT), null);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return determineTargetDataSource().getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return determineTargetDataSource().getConnection(username, password);
    }

    private DataSource determineTargetDataSource() {

        String clientId = ClientXrefHolder.getClientXref();
        if (clientId == null) {
            clientId = DEFAULT_CLIENT_XREF;
        }

        DataSource dataSource = clientDataSources.get(clientId);
        if (dataSource == null) {
            final String message = String.format(
                    "Couldn't find data source for client \"%s\".", clientId);
            throw new IllegalStateException(message);
        }

        return dataSource;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return determineTargetDataSource().unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return determineTargetDataSource().isWrapperFor(iface);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return determineTargetDataSource().getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        determineTargetDataSource().setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        determineTargetDataSource().setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return determineTargetDataSource().getLoginTimeout();
    }

    @Override
    public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return determineTargetDataSource().getParentLogger();
    }

}