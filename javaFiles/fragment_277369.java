public final class ValueNode implements ExprNode {

    private final int value;

    public ValueNode(final int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return this.value;
    }

    @Override
    public String asInfixString() {
        return String.valueOf(this.value);
    }
}