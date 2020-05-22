public class HibernateUtil {
    private static final SessionFactory concreteSessionFactory;
    static {
        try {
            Properties prop= new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate");
            prop.setProperty("hibernate.connection.username", "root");
            prop.setProperty("hibernate.connection.password", "");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
            prop.setProperty("hbm2ddl.auto", "create");

            concreteSessionFactory = new AnnotationConfiguration()
           .addPackage("com.persistence")
                   .addProperties(prop)
                   .addAnnotatedClass(User.class)
                   .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession()
            throws HibernateException {
        return concreteSessionFactory.openSession();
    }

    public static void main(String... args){
        Session session=getSession();
        session.beginTransaction();
        User user=(User)session.get(User.class, new Integer(1));
        System.out.println(user.getName());
        session.close();
    }
    }