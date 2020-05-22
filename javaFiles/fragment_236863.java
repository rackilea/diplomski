Configuration configuration = new Configuration()
    .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

// [...] adding annotated classes to metadata here...
configuration.addAnnotatedClass(...);

configuration.generateSchemaCreationScript(
    Dialect.getDialect(configuration.getProperties()));
SchemaExport export = new SchemaExport(configuration, connection);
export.create(true, true);