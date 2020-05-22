abstract class Base {
    abstract String getValue();
}

class A extends Base {

    static String aValue = "From A";

    String getValue() {
        return aValue;
    }
}

class B extends A {

    static String bValue = "From B";

    String getValue() {
        return bValue;
    }
}