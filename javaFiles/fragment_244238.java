@Override
protected void setUp() throws Exception {
    super.setUp();
    String dialectClassName = HSQLDialect.class.getName();
    AnnotationConfiguration config = new AnnotationConfiguration().addAnnotatedClass(DividendScheduleGeneratorImpl.class);

    config.setProperty(Environment.DIALECT, dialectClassName);
    config.setProperty(Environment.DRIVER, jdbcDriver.class.getName());
    config.setProperty(Environment.URL, "jdbc:hsqldb:mem:testDB");
    config.setProperty(Environment.USER, "SA");
    config.setProperty(Environment.PASS, "");

    SchemaExport export = new SchemaExport(config);
    export.create(false, true);

    sessions = config.buildSessionFactory();
}

@Override
protected void tearDown() throws Exception {
    sessions.close();
    sessions = null;

    super.tearDown();
}