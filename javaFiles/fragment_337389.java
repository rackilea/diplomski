public class MethodCallPrinter
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream in = new FileInputStream("MethodCallPrinter.java");

        CompilationUnit cu;
        try
        {
            cu = JavaParser.parse(in);
        }
        finally
        {
            in.close();
        }
        new MethodVisitor().visit(cu, null);
    }

    private static class MethodVisitor extends VoidVisitorAdapter
    {
        @Override
        public void visit(MethodCallExpr methodCall, Object arg)
        {
            System.out.print("Method call: " + methodCall.getName() + "\n");
            List<Expression> args = methodCall.getArgs();
            if (args != null)
                handleExpressions(args);
        }

        private void handleExpressions(List<Expression> expressions)
        {
            for (Expression expr : expressions)
            {
                if (expr instanceof MethodCallExpr)
                    visit((MethodCallExpr) expr, null);
                else if (expr instanceof BinaryExpr)
                {
                    BinaryExpr binExpr = (BinaryExpr)expr;
                    handleExpressions(Arrays.asList(binExpr.getLeft(), binExpr.getRight()));
                }
            }
        }
    }
}