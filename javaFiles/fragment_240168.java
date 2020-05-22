public class DefaultInitializeCollectionEventListener
      implements InitializeCollectionEventListener {
  public void onInitializeCollection(InitializeCollectionEvent event)
        throws HibernateException {
    …
    final boolean traceEnabled = LOG.isTraceEnabled();
    …

    final boolean foundInCache = methodReturningTrueWhenInCache();

    if ( foundInCache && traceEnabled ) {
      LOG.trace( "Collection initialized from cache" );
    }
    else {
      if ( traceEnabled ) {
        LOG.trace( "Collection not cached" );
      }
      methodThatExecutesAQuery();
  }
}