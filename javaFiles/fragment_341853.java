interface IFoo {
    public default String name() {
        return "foo";
    }
}

enum MyEnum implements IFoo {
    A, B, C
}

System.out.println( MyEnum.A.name() );  // Prints "A", not "foo" - superclass Enum wins