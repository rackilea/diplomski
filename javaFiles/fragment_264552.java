AnnotationConfiguration configuration = new AnnotationConfiguration();

configuration
    .addAnnotatedClass(ClassA.class)
    .addAnnotatedClass(ClassB.class)
    .addAnnotatedClass(ApprovalItem.class)
    .setProperty(Environment.USER, <TYPE_YOUR_USER>)
    .setProperty(Environment.PASS, <TYPE_YOUR_PASSWORD>)
    .setProperty(Environment.URL, <TYPE_YOUR_URL>)
    .setProperty(Environment.DIALECT, <TYPE_YOUR_DIALECT>)
    .setProperty(Environment.DRIVER, <TYPE_YOUR_DRIVER>);

SchemaExport schema = new SchemaExport(configuration);
schema.setOutputFile("schema.sql");

schema.create(<DO_YOU_WANT_TO_PRINT_TO_THE_CONSOLE>, <DO_YOU_WANT_TO_EXPORT_THE_SCRIPT_TO_THE_DATABASE>);