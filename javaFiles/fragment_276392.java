protected Collection<Object> findFacts( 
        final StatefulKnowledgeSession session, 
        final String factClass ) {
    ObjectFilter filter = new ObjectFilter() {
    @Override
        public boolean accept( Object object ) {
            return object.getClass().getSimpleName().equals( factClass );
        }
    };

    Collection<Object> results = session.getObjects( filter );
    return results;
}