public class LocalSessionFactoryBean extends HibernateExceptionTranslator
        implements FactoryBean<SessionFactory> {

    public SessionFactory getObject() {
        return this.sessionFactory;
    }

}