// testString is your example statement
Insert stmt = (Insert) CCJSqlParserUtil.parse(testString);
stmt.accept(new StatementVisitorAdapter() {
    @Override
    public void visit(Insert insert) {
        ItemsList list = insert.getItemsList();
        list.accept(new ItemsListVisitorAdapter() {
            @Override
            public void visit(ExpressionList expressionList) {
                Expression expression = expressionList.getExpressions().get(9);
                if (expression instanceof StringValue) {
                    StringValue val = (StringValue) expression;
                    expressionList.getExpressions().set(9, 
                        new StringValue(val.getValue().toUpperCase()));
                }
            }
        });
    }
});
System.out.println(stmt.toString());