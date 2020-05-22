abstract class LeftRightType extends Type {

    private Type left, right;
    private BinaryOperator<Type> typeSupplier;

    public LeftRightType(Type left, Type right, BinaryOperator<Type> typeSupplier) {
        this.left = left;
        this.right = right;
        this.typeSupplier = typeSupplier;
    }

    public Type simplify() {
        return typeSupplier.apply(left.simplify(), right.simplify()).simplify();
    }
}