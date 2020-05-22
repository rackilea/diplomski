public static String foo() {
    return null;
}

public static <T> T bar() {
    return null;
}

public static <T> T baz(Class<T> clazz) {
    return null;
}

public static void main(String[] args) {
   var a = null;  // compile error
   var b = foo(); // fine
   var c = bar(); // fine
   var d = baz(String.class); //fine
}