public static void main(String[] args) throws SecurityException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
    String someString = "IMMUTABLE";
    // ...

    System.out.println(someString); // prints NOTREALLY
    Separate.show();
}