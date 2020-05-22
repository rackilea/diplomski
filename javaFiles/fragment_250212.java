Connection unwrapConnection = databaseSession.getServerPlatform()
                .unwrapConnection(accessor.getConnection());
        oracle.jdbc.OracleConnection connection = null;
        try {
            if (unwrapConnection.isWrapperFor(OracleConnection.class)) {
                connection = unwrapConnection.unwrap(OracleConnection.class);
            } else {
                // recover, not an oracle connection
                connection = (oracle.jdbc.OracleConnection) databaseSession.getServerPlatform()
                        .unwrapConnection(accessor.getConnection());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }