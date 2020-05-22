class A {
    public static void main( String ... args ) {
        String [] a = { "a", "b", "c" };
        String [] b = { "a", "b", "c" };
        String [] c = a;

        System.out.println(a.equals(b));// false, same content but different object.
        System.out.println(a.equals(c));// true, they are the same object
    }
}