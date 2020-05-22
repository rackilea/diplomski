public final class TimesNode implements ExprNode {

    private final ExprNode lhs;
    private final ExprNode rhs;

    public TimesNode(final ExprNode lhs, final ExprNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public int evaluate() {
        return this.lhs.evaluate() * this.rhs.evaluate();
    }

    @Override
    public String asInfixString() {
        return String.format("(%s) * (%s)",
                             this.lhs.asInfixString(),
                             this.rhs.asInfixString());
    }
}