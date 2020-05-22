class InheritedType extends LeftRightType {
    public InheritedType(Type left, Type right) {
        super(left, right);
    }
    @Override
    public Type newInstance(Type left, Type right) {
        return new InheritedType(left, right);
    }
}

class InheritedType2 extends LeftRightType {
    public InheritedType2(Type left, Type right) {
        super(left, right);
    }
    @Override
    public Type newInstance(Type left, Type right) {
        return new InheritedType2(left, right);
    }
}