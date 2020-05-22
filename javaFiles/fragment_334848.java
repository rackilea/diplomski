abstract class LeftRightType extends Type {

    private Type left, right;

    public LeftRightType(Type left, Type right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Type simplify() {
        return newInstance(left.simplify(), right.simplify()).simplify();
    }

    public abstract Type newInstance(Type left, Type right);

}