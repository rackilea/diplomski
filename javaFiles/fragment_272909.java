Properties p = new Properties();
p.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.openejb.client.LocalInitialContextFactory");

p.put("movie-unit.hibernate.hbm2ddl.auto", "update");
p.put("movie-unit.hibernate.dialect", "org.hibernate.dialect.HSQLDialect");

context = new InitialContext(p);