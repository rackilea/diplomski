public class MyClass {
    static Map<MyEnum, BiConsumer<MyClass,String>> methodMapping;
    static {
        methodMapping = new EnumMap<>(MyEnum.class);

        methodMapping.put(MyEnum.FIRST,  MyClass::firstMethod);
        methodMapping.put(MyEnum.SECOND, MyClass::secondMethod);
    }
    void firstMethod(String param) {
        ...
    }
    void secondMethod(String param) {
        ...
    }
    void callTheMethod(MyEnum e, String s) {
        methodMapping.get(e).accept(this, s);
    }
}