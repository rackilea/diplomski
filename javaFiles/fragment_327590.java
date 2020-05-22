...
ENUM_A  (1, "test1", TestADto::new),
ENUM_B  (2, "test2", TestBDto::new),
ENUM_C  (3, "test3", TestCDto::new);

private Function <MyInterface, Dto> dtoConstructor;

TestEnum(int i, String name, Function <MyInterface, Dto> dtoConstructor){
    this.dtoConstructor = dtoConstructor;
    ...
}

public Dto createInstance(MyInterface myInterface){
    return myInterfaceToDtoFunction.apply(myInterface);
}

...