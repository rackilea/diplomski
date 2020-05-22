static void getDDL(String packageName, String propertiesFile) throws IOException {

    MetadataSources metadata = new MetadataSources(
        new StandardServiceRegistryBuilder()
            .loadProperties(propertiesFile)
            .build());

    new Reflections(packageName)
        .getTypesAnnotatedWith(Entity.class)
        .forEach(metadata::addAnnotatedClass);

    //STDOUT will export to output window, but other `TargetType` values are available to export to file or to the db.
    EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.STDOUT);

    SchemaExport export = new SchemaExport();

    export.setDelimiter(";");
    export.setFormat(true);

    export.createOnly(targetTypes, metadata.buildMetadata());
}