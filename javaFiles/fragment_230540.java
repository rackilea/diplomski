public void objectPropertiesForType(Model m, final Resource type) {
    StmtIterator i = m.listStatements(new SimpleSelector() {
        @Override
        public boolean test(Statement s) {
            if (s.getPredicate().equals(RDFS.domain)
                    || s.getPredicate().equals(RDFS.range)) {
                return (s.getObject().equals(type));
            }
            return false;
        }
    });
    while (i.hasNext()) {
        Statement s = i.next();
        System.out.println("Property: " + s.getSubject().getURI());
    }
}