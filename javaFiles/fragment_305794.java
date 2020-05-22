OWLEquivalentClassesAxiom ax=null;
ax.accept(new OWLObjectVisitor() {
    @Override
    public void visit(OWLObjectIntersectionOf ce) {
        ce.operands().filter(x->x.isOWLClass()).forEach(x->{
            // this is where x is Person, or any other 
            // named class in the intersection;
            // anonymous classes are skipped
        });
    }
});