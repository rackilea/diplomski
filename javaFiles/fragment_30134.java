enum OuterEnum {
    OUTER1(InnerEnum.INNER1), OUTER2(InnerEnum.INNER2);
    public final InnerEnum myInner;
    private OuterEnum(InnerEnum inner) {
        this.myInner = inner;
    }
}

enum InnerEnum {
    INNER1, INNER2;
}