public class ReadOnlySessionFactoryBean extends AbstractFactoryBean
{
    private AbstractSessionFactoryBean sessionFactoryBean;

    public ReadOnlySessionFactoryBean(AbstractSessionFactoryBean sessionFactoryBean)
    {
        this.sessionFactoryBean = sessionFactoryBean;
    }

    @Override
    public Class getObjectType()
    {
        return sessionFactoryBean.getObjectType();
    }

    @Override
    protected Object createInstance() throws Exception
    {
        SessionFactory factory = sessionFactoryBean.getObject();
        return new WrapSessionFactory(factory);
    }

    static class WrapSessionFactory implements SessionFactory
    {
        private Sessionfactory delegate;

        WrapSessionFactory(SessionFactory delegate)
        {
            this.delegate = delegate;
        }

        // delegate most methods to the delegate SessionFactory

        // override all the openSession(...) methods
        public Session openSession()
        {
            Session session = delegate.openSession();
            session.setDefaultReadOnly(true);
            return session;
        }
    }
}