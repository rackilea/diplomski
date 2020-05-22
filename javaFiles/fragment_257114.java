class A extends BaseClass<A.AnotherEnum> {

    enum AnotherEnum implements SpecialEnum {

        Hello, All;
    }

    public A(AnotherEnum e) {
        super(e);
    }

}