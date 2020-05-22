import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

private static final SessionFactory sessionFactory;

static {
    try {
        Configuration cfg = new Configuration();
        sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
    } catch (Throwable ex) {
        Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, ex);
        throw new ExceptionInInitializerError(ex);
    }
}

public static SessionFactory getSessionFactory() {
    return sessionFactory;
}