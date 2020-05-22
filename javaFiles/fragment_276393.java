protected Collection<Object> findFacts( 
        final StatefulKnowledgeSession session, 
        final Class factClass ) {
    ObjectFilter filter = new ObjectFilter() {
    @Override
        public boolean accept( Object object ) {
            return object.getClass().equals( factClass );
        }
    };

    Collection<Object> results = session.getObjects( filter );
    return results;
}