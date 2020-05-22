public abstract class Expression
public abstract class BinaryExpression extends Expression {
    private Expression expr1;
    private Expression expr2;
    public Expression getExpr1() { return expr1; }
    public void setExpr1(Expression expr) { expr1 = expr; }
}
public abstract class UnaryExpression extends Expression
public class Or extends BinaryExpression
public class Not extends UnaryExpression