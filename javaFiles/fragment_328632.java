EntityManagerFactory entityManagerFactory = appContext.getBean( "entityManagerFactory", EntityManagerFactory.class );

String dialect = (String) entityManagerFactory.getProperties().getOrDefault( "hibernate.dialect", "" );

log.debug( "{}={}", "hibernate.dialect", dialect );


2019-04-17 02:02:59.228 DEBUG 12724 --- [           main] c.c.n.d.Application           : hibernate.dialect=org.hibernate.dialect.SQLServer2012Dialect