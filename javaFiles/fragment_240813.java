public class TestHB4 {
    private static StandardServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("Namal");
        person.setLastName("Dinesh");


        Configuration configuration = new Configuration().configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.configure().buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(person);

        session.getTransaction().commit();
        session.close();


    }