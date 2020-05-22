// First create the mock JNDI tree and bind the DS
SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
DataSource ds = new ComboPooledDataSource();
ds.setDriverClass( ... ); // etc. for uid, password, url
builder.bind( "java:comp/env/jdbc/MyDS" , ds );
builder.activate();

// Then create the Spring context, which should now be able 
// to resolve the JNDI datasource
ApplicationContext context = new ClassPathXmlApplicationContext( "..." );