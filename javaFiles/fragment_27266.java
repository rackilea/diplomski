public class HibernateUtil {
        private static SessionFactory sessionFactory;
        private static ServiceRegistry serviceRegistry;
        static {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Role.class);

                serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                System.out.println(e);
            }
        }

        public static SessionFactory getSessionFactory(){
            return sessionFactory;
        }
}