PoolProperties p = new PoolProperties();
      p.setUrl("jdbc:your-jdbc-url");
      p.setDriverClassName("your.jdbc.driver.class");
      p.setUsername("user");
      p.setPassword("password");
      p.setJdbcInterceptors(
        "org.apache.tomcat.jdbc.pool.interceptor.StatementCache");
      DataSource datasource = new DataSource();
      datasource.setPoolProperties(p);