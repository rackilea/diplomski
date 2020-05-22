public final class JpaSchemaExporter
{
    public JpaSchemaExporter(String utilName, String packageName, Properties properties, DialectType dialect,
                 Path outputPath) throws Exception
    {
        this.dialect = dialect;
        this.outputPath = outputPath;

        if (Files.exists(outputPath) && !Files.isDirectory(outputPath)) {
            throw new IllegalArgumentException(
                "Given path already exist and is not a directory! the path:" + outputPath);
        }
        Files.createDirectories(outputPath);

        pud = new ParsedPersistenceXmlDescriptor(Resources.getResourceURL("META-INF"));
        pud.setName(utilName);
        pud.addClasses(Resources.getClasseNames(packageName));
        pud.addMappingFiles("META-INF/orm.xml");
        properties.setProperty("hibernate.dialect", dialect.getDialectClass());

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        factoryBuilder = new EntityManagerFactoryBuilderImpl( pud, properties );
        factoryBuilder.withValidatorFactory(validatorFactory).build().close(); // create HibernateConfiguration instance
        this.injectBeanValidationConstraintToDdlTranslator();
        validatorFactory.close();
    }

    private void injectBeanValidationConstraintToDdlTranslator() {
        try {
            Configuration hibernateConfiguration = factoryBuilder.getHibernateConfiguration();
            ValidatorFactory validatorFactory = (ValidatorFactory) factoryBuilder.getConfigurationValues().get(AvailableSettings.VALIDATION_FACTORY);
            // private class in hibernate
            Method applyRelationalConstraints = Class.forName("org.hibernate.cfg.beanvalidation.TypeSafeActivator")
                .getMethod("applyRelationalConstraints",
                       ValidatorFactory.class,
                       java.util.Collection.class,
                       Properties.class,
                       Dialect.class);
            applyRelationalConstraints.setAccessible(true);
            Dialect dialectInstance = (Dialect) Class.forName(dialect.getDialectClass()).newInstance();
            applyRelationalConstraints.invoke(null, validatorFactory,
                              Arrays.asList(Iterators.toArray(hibernateConfiguration.getClassMappings(), PersistentClass.class)) ,
                              hibernateConfiguration.getProperties(),
                              dialectInstance);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public void create() throws IOException {
        Configuration cfg = factoryBuilder.getHibernateConfiguration();
        cfg.setProperty("hibernate.hbm2ddl.auto", "create");
        SchemaExport export = new SchemaExport(cfg);
        export.setDelimiter(";");
        export.setOutputFile(Paths.get(outputPath.toString(), "ddl_create_" + dialect.name().toLowerCase() + ".sql").toString());
        export.execute(true, false, false, true);
        if (!export.getExceptions().isEmpty()) {
            System.out.println();
            System.out.println("SOME EXCEPTIONS OCCURED WHILE GENERATING THE UPDATE SCRIPT:");
            for (Exception e : (List<Exception>) export.getExceptions()) {
            System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void update() throws IOException {
        Configuration cfg = factoryBuilder.getHibernateConfiguration();
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        SchemaUpdate updater = new SchemaUpdate(cfg);
        updater.setDelimiter(";");
        updater.setOutputFile(Paths.get(outputPath.toString(), "ddl_update_" + dialect.name().toLowerCase() + ".sql").toString());
        updater.execute(true, false);
        if (!updater.getExceptions().isEmpty()) {
            System.out.println();
            System.out.println("SOME EXCEPTIONS OCCURED WHILE GENERATING THE UPDATE SCRIPT:");
            for (Exception e : ((List<Exception>) updater.getExceptions())) {
            System.out.println(e.getMessage());
            }
        }
    }

    public void validate() {
        Configuration hibernateConfiguration = factoryBuilder.getHibernateConfiguration();
        hibernateConfiguration.setProperty("hibernate.hbm2ddl.auto", "validate");
        SchemaValidator validator = new SchemaValidator(hibernateConfiguration);
        validator.validate();
    }

    public static void main(String[] args) throws Exception {
        Properties prop = new Properties(System.getProperties());
        prop.setProperty("hibernate.connection.driver_class", "value in your env");
        prop.setProperty("hibernate.connection.url", "value in your env");
        prop.setProperty("hibernate.connection.username", "value in your env");
        prop.setProperty("hibernate.connection.password", "value in your env");
        Path path = Paths.get("schema output path in your env");
        String packageName = prop.getProperty("package names of jpa classes");
        String unitName = prop.getProperty("jpa Unit Name");
        String[] dialects = "HSQL,MYSQL".split(",");
        for(String dialect : dialects){
            DialectType dialectType = DialectType.valueOf(dialect);
            JpaSchemaExporter ddlExporter = new JpaSchemaExporter(unitName, packageName, prop, dialectType, path);
            ddlExporter.update();
            ddlExporter.create();
        }
    }
}