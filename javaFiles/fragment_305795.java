for(OWLClass clazzzz : ontology.getClassesInSignature()) {
    for(OWLEquivalentClassesAxiom ax: ontology.getEquivalentClassesAxioms(clazzzz)) {
        OWLObjectVisitorAdapter visitor = new OWLObjectVisitorAdapter() {
        @Override
        public void visit(OWLObjectIntersectionOf ce) {
            for (OWLClassExpression e : ce.getOperands()) {
                if (!e.isAnonymous()) {
                    // this is where x is Person, or any other
                    // named class in the intersection;
                    // anonymous classes are skipped
                }
            }
        }
        };
        ax.accept(visitor);
    }
}