EventListenerRegistry registry = ((SessionFactoryImpl)sessionFactory).getServiceRegistry().getService(EventListenerRegistry.class);
registry.appendListeners(EventType.INIT_COLLECTION, new InitializeCollectionEventListener());

public class InitializeCollectionEventListener implements InitializeCollectionEventListener{
    DefaultInitializeCollectionEventListener defaultListener;
    InitializeCollectionEventListener(){
        defaultListener = new DefaultInitializeCollectionEventListener();
    }
    public void onInitializeCollection(InitializeCollectionEvent pEvent) throws HibernateException {
        defaultListener.onInitializeCollection(pEvent);
        SessionImpl si = (SessionImpl) pEvent.getSession();
        if (!si.isTransactionInProgress() && !si.isClosed() && si.isConnected() && 
                si.getConnectionReleaseMode().equals(ConnectionReleaseMode.AFTER_TRANSACTION)){
            si.getTransactionCoordinator().getJdbcCoordinator().getLogicalConnection().aggressiveRelease(); 
        }
    }

}