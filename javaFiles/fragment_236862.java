MetadataSources metadata = new MetadataSources(
    new StandardServiceRegistryBuilder()
        .applySetting("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
        .build());

// [...] adding annotated classes to metadata here...
metadata.addAnnotatedClass(...);

SchemaExport export = new SchemaExport(
    (MetadataImplementor) metadata.buildMetadata(),
    connection // pre-configured Connection here
);
export.create(true, true);