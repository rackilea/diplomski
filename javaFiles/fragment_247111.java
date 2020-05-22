public class Main {

  public static void main(String[] args) {

    String expression = "(1 + 2) * 14";
    ExpressionLexer lexer = new ExpressionLexer(CharStreams.fromString(expression));
    ExpressionParser parser = new ExpressionParser(new CommonTokenStream(lexer));
    EvalListener evaluator = new EvalListener();
    ParseTreeWalker.DEFAULT.walk(evaluator, parser.expression());

    System.out.printf("%s = %s\n", expression, evaluator.stack.pop());
  }

  static class EvalListener extends ExpressionBaseListener {

    final Stack<Double> stack = new Stack<>();

    @Override
    public void exitExpressionAdd(ExpressionParser.ExpressionAddContext ctx) {
      Double rhs = stack.pop();
      Double lhs = stack.pop();
      this.stack.push(ctx.op.getType() == ExpressionLexer.ADD ? (lhs + rhs) : (lhs - rhs));
    }

    @Override
    public void exitExpressionMul(ExpressionParser.ExpressionMulContext ctx) {
      Double rhs = stack.pop();
      Double lhs = stack.pop();
      this.stack.push(ctx.op.getType() == ExpressionLexer.MUL ? (lhs * rhs) : (lhs / rhs));
    }

    @Override
    public void enterExpressionNumber(ExpressionParser.ExpressionNumberContext ctx) {
      this.stack.push(Double.valueOf(ctx.getText()));
    }
  }
}