final Configuration hibConfiguration = new Configuration().configure(yourCFGPath);         
final org.hibernate.service.ServiceRegistry serviceRegistry = new org.hibernate.boot.registry
.StandardServiceRegistryBuilder().
applySettings(hibConfiguration.getProperties()).build();
hibConfiguration.setSessionFactoryObserver(new SessionFactoryObserver()
{
    @Override
    public void sessionFactoryCreated(SessionFactory factory){}
    @Override
    public void sessionFactoryClosed(SessionFactory factory)
    {
        ((StandardServiceRegistryImpl)serviceRegistry).destroy();
    }});                
 final org.hibernate.SessionFactory factory = hibConfiguration.buildSessionFactory(serviceRegistry);