@BeforeMethod
public void setupSchema() {
    LocalSessionFactoryBean session = (LocalSessionFactoryBean) context.getBean("&sessionFactory");
    SchemaExport export = new SchemaExport(session.getConfiguration());
    export.drop(false, true);
    export.create(false, true);
}