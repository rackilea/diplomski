public static void main(String[] args) {
    String var1 = "Hello";
    doSomething(var1); // The value of var1 is copied to param1
}
private static void doSomething(String param1) {
    param1 = null; // Only clears the param1 reference
    var1 = null; // Cannot do this, because doSomething() does not have access to var1
}