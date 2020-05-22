// in constructor
cpds = new ComboPooledDataSource();
cpds.setDriverClass( "org.postgresql.Driver" ); //loads the jdbc driver            
cpds.setJdbcUrl( "jdbc:postgresql://localhost/testdb" );
cpds.setUser("swaldman");                                  
cpds.setPassword("test-password");