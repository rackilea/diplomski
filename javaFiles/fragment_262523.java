if ( enversService.getEntityConfigurations().hasAuditedEntities() ) {
  // ...
  listenerRegistry.appendListeners( 
    EventType.PRE_UPDATE, 
    new MyCustomEnversPreUpdateEventListener( enversService )
  );
}