String whereClause = "a=3 AND b=4 AND c=5 AND d>5 AND x<10";
    Expression expr = CCJSqlParserUtil.parseCondExpression(whereClause);
    expr.accept(new ExpressionVisitorAdapter() {

        @Override
        protected void visitBinaryExpression(BinaryExpression expr) {
            if (expr instanceof ComparisonOperator) {
                System.out.println("left=" + expr.getLeftExpression() + "  op=" +  expr.getStringExpression() + "  right=" + expr.getRightExpression());
            }

            super.visitBinaryExpression(expr); 
        }
    });