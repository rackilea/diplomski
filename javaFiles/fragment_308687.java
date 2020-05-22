@Bean (destroyMethod = "close")
public DataSource dataSource() {

    PoolProperties p = new PoolProperties();
    p.setUrl(Settings.getInstance().config.database.url+"?useUnicode=true&characterEncoding=UTF-8");
    p.setDriverClassName(Settings.getInstance().config.database.driver);
    p.setUsername(Settings.getInstance().config.database.user);
    p.setPassword(Settings.getInstance().config.database.password);
    p.setJmxEnabled(false);
    p.setTestWhileIdle(false);
    p.setTestOnBorrow(true);
    p.setValidationQuery("SELECT 1");
    p.setTestOnReturn(false);
    p.setValidationInterval(30000);
    p.setTimeBetweenEvictionRunsMillis(30000);
    p.setMaxActive(100);
    p.setInitialSize(10);
    p.setMaxWait(10000);
    p.setRemoveAbandonedTimeout(60);
    p.setMinEvictableIdleTimeMillis(30000);
    p.setMinIdle(10);
    p.setLogAbandoned(true);
    p.setRemoveAbandoned(true);
    p.setJdbcInterceptors(
            "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
            + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;"
            + "org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer");
         org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
         ds.setPoolProperties(p);
         return ds;
 }