@Test
public void doWithoutAnnotations() {

    Configuration configuration = new Configuration().configure();

    SessionFactory sessionFactory = configuration.buildSessionFactory();

    Session session = sessionFactory.openSession();
    session.beginTransaction();

    Parent parent = new Parent();
    parent.setChildArray(new AbstractChild[] {new Child("AAA"), new Child("BBB")});

    session.save(parent);

    session.getTransaction().commit();
    session.close();
}