/**
 * Visitor which counts expression statements
 */
GenericVisitorAdapter<ExpressionStmt, Integer> expressionsCountVisitor = new GenericVisitorAdapter<ExpressionStmt, Integer>() {

        /**
         * This is based on your example
         */
        @Override
        public ExpressionStmt visit(ExpressionStmt expressionStmt, Integer count) {
            if(expressionStmt.toString().contains("=")) {
                count++;
            }
            return super.visit(expressionStmt, count);
        }

        /**
         * But better to check for AssignExpr instead of ".contains("=")"
         */
        @Override
        public ExpressionStmt visit(AssignExpr assignExpr, Integer count) {
            // counts each "=" assign expression
            count++;
            return super.visit(assignExpr, count);
        }

    };

// And then use this visitor for each MethodDecalration

public void visit(MethodDeclaration methodDeclaration, Object arg) {
    Integer total = 0;
    // traverses down the hierarchy of this method declaration
    methodDeclaration.accept(expressionsCountVisitor, total);
    super.visit(methodDeclaration, arg);
    System.out.println(total);
}