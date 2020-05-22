private static DriverManagerDataSource dataSource;

@BeforeClass
public static void setupClass() throws Exception {
    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScript(new ClassPathResource("path/to/package/defaults.sql"));
    dataSource = new DriverManagerDataSource(); 
    dataSource.setUrl("jdbc:hsqldb:mem:pgtest;sql.syntax_pgs=true");
    dataSource.setUsername("SA");

    Connection con = dataSource.getConnection();
    assertNotNull(con);
    populator.populate(con);
    con.close();
}