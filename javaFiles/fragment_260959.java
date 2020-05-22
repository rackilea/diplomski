ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
            String.format("jdbc:mysql://%s:%d/%s", host, port, db), null);
PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(
            connectionFactory, null);
GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
poolConfig.setMaxTotal(100);
ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(
        poolableConnectionFactory, poolConfig);
poolableConnectionFactory.setPool(connectionPool);
PoolingDataSource<PoolableConnection> dataSource = new PoolingDataSource<>(
        connectionPool);
return dataSource;