MetadataSources metadata = new MetadataSources(
    new StandardServiceRegistryBuilder()
        .applySetting("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
        .applySetting("javax.persistence.schema-generation-connection", connection)
        .build());

// [...] adding annotated classes to metadata here...
metadata.addAnnotatedClass(...);

SchemaExport export = new SchemaExport();
export.create(EnumSet.of(TargetType.DATABASE), metadata.buildMetadata());