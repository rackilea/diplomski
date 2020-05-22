// Add the statistics module to the connector
ConnectorStatistics stats = new ConnectorStatistics();
connector.addBean(stats);

// Then access the information.
System.out.printf("Connector.getConnections() = %,d%n", stats.getConnections());
System.out.printf("Connector.getConnectionsOpen() = %,d%n", stats.getConnectionsOpen());
System.out.printf("Connector.getConnectionsMax() = %,d%n", stats.getConnectionsMax());