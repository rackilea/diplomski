...
MyEnum.fromDesc(str)
    .ifPresent(SomeClass::methodWithSwitchStatement);
...
class SomeClass {
    public static void methodWithSwitchStatement(MyEnum myEnum) {
        switch(myEnum){
            case EMPLOYEE_NUMBER:
               //setter
               break;
        }
    }
}
...