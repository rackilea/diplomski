@Test
public void doWithAnnotations() {

    AnnotationConfiguration configuration = new AnnotationConfiguration();

    SessionFactory sessionFactory = configuration

        .addAnnotatedClass(Parent.class)
        .addAnnotatedClass(Child.class)
        .addAnnotatedClass(AbstractChild.class)
        .setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver")
        .setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/ar")
        .setProperty(Environment.USER, "root")
        .setProperty(Environment.PASS, "root")
        .setProperty(Environment.SHOW_SQL, "true")
        .setProperty(Environment.FORMAT_SQL, "true")
        .setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect")
        .setProperty(Environment.HBM2DDL_AUTO, "create-drop").buildSessionFactory();

    Session session = sessionFactory.openSession();
    session.beginTransaction();

    Parent parent = new Parent();
    parent.setChildArray(new AbstractChild[] {new Child("AAA"), new Child("BBB")});

    session.save(parent);

    session.getTransaction().commit();
    session.close();
}