interface BusinessLogicInterace
{
    void method1();
    void method2();
}

class BusinessLogic implements BusinessLogicInterface
{
    void method1() { ... }
    void method2() { ... }
}

class User 
    extends OtherClass 
    implements BusinessLogicInterface
{
    BusinessLogic logic = new BusinessLogic();

    @Override
    void method1() { logic.method1(); }

    @Override
    void method2() { logic.method2(); }
}