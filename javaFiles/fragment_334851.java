class InheritedType extends LeftRightType {
    public InheritedType(Type left, Type right) {
        super(left, right, InheritedType::new);
    }
}

class InheritedType2 extends LeftRightType {
    public InheritedType2(Type left, Type right) {
        super(left, right, InheritedType2::new);
    }
}