public SomeEnum returnAType(String someString) {
    SomeEnum enumType = method1(someString) ? SomeEnum.ENUM1 :
                        method2(someString) ? SomeEnum.ENUM2 :
                        method3(someString) ? SomeEnum.ENUM3 : SomeEnum.DEFAULT_ENUM;
    enumType.doSomething();
    return enumType;