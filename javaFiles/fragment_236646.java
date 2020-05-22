BasicDataSource ds = new BasicDataSource();
ds.setDriverClassName(DATABASE_DRIVER_CLASS);
ds.setUsername(DATABASE_USERNAME);
ds.setPassword(DATABASE_PASSWORD);
ds.setUrl(DATABASE_URL);
ds.setInitialSize(1);
ds.setMaxActive(50);
ds.setDefaultAutoCommit(false);