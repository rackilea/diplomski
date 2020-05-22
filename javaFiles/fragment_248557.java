class Base {
    protected static String value = "Base";

    public static String getValue() {
        return value;
    }
}

class Derived extends Base {
    static {
        value = "Derived";
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        // Make sure we run static initializer for Derived class
        Class.forName("Derived");
        System.out.println(Derived.getValue());
        System.out.println(Base.getValue());
    }
}