package org.apache.tomcat.jdbc.pool;

public interface AbandonedConnectionHandler {

        public void handleQuery(Long connectionId);

}