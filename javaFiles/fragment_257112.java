enum MyEnum {

    I, Me, My, Mine;
}

class A extends BaseClass<MyEnum> {

    public A(MyEnum e) {
        super(e);
    }

}