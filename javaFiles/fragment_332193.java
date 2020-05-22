OWLClassExpressionVisitor visitor = new OWLClassExpressionVisitor() {
        public void visit(OWLObjectMinCardinality c) {
            int superClassIICardinality = c.getCardinality();
        }

        @Override
        public void visit(OWLObjectExactCardinality ce) {
            int superClassIICardinality = c.getCardinality();
        }
    };
    superClassII.accept(visitor);