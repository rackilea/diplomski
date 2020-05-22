public static void main(String[] args) throws SecurityException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
    Separate.show(); // <================ Note

    String someString = "IMMUTABLE";
    // ...

    System.out.println(someString); // prints NOTREALLY
    Separate.show();
}