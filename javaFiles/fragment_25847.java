public class Main {

    public static void main(String[] args) {
        String insertSQL = "INSERT INTO emp (empno, ename, job, sal, comm, deptno, joinedon) VALUES (4160, 'STURDEVIN', 'SECURITY GUARD', 2045, NULL, 30, TO_TIMESTAMP('2014-07-02 06:14:00.742000000', 'YYYY-MM-DD HH24:MI:SS.FF'));";
        final Statement statement;
        try {
            statement = CCJSqlParserUtil.parse(insertSQL);
            if (statement instanceof Insert) {
                final Insert insertStatement = (Insert) statement;
                System.out.println("insertStatement: " + insertStatement);
                List<Column> columns = insertStatement.getColumns();
                for (final Column column : columns) {
                    System.out.println("column: " + column);
                }
                ItemsList itemsList = insertStatement.getItemsList();
                System.out.println("itemsList: " + itemsList);
                final Delete deleteStatement = new Delete();
                deleteStatement.setTable(insertStatement.getTable());

                // get the list of values
                ExpressionList expressionList = (ExpressionList) itemsList;
                List<Expression> values = expressionList.getExpressions();

                // create the "column = value" expressions list
                List<Expression> expressions = new ArrayList<>();
                for (int i = 0; i < columns.size(); i++) {
                    // create the "column = value" expression
                    EqualsTo equalsTo = new EqualsTo();
                    equalsTo.setLeftExpression(columns.get(i));
                    equalsTo.setRightExpression(values.get(i));

                    // add it to the list
                    expressions.add(equalsTo);
                }

                // glue together the expressions with "ANDs"
                // it is now our where expression
                MultiAndExpression whereExpression = new MultiAndExpression(expressions);

                deleteStatement.setWhere(whereExpression);

                System.out.println("deleteStatement: " + deleteStatement);
            }
        } catch (JSQLParserException e) {
            e.printStackTrace();
        }
    }
}