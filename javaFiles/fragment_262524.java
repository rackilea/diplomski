public class MyCustomEnversPreUpdateEventListener 
  extends EnversPreUpdateEventListenerImpl {
  @Override
  public void onPreUpdate(PreUpdateEvent event) {
    final String entityName = event.getPersister().getEntityName();
    if ( getEnversService().getEntitiesConfigurations().isVersioned( entityName ) ) {
        checkIfTransactionInProgress( event.getSession() );
        if ( yourFieldStatusMatchesAuditCriteria( event ) ) {
          return super.onPreUpdate( event );
        }
    }
    return false;
  }
}