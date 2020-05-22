.applySetting(AvailableSettings.CONNECTION_PROVIDER, new ConnectionProvider() {
            @Override
            public boolean isUnwrappableAs(Class unwrapType) {
                return false;
            }
            @Override
            public <T> T unwrap(Class<T> unwrapType) {
                return null;
            }
            @Override
            public Connection getConnection() {
                return connection; // Interesting part here
            }
            @Override
            public void closeConnection(Connection conn) throws SQLException {}

            @Override
            public boolean supportsAggressiveRelease() {
                return true;
            }
        })