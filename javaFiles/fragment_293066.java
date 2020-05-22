package pkg1;                 // Changed from pkg2
//import pkg1.A;              // Not necessary anymore.
public class B extends A {
    public static void main(String args[]) {
        new A().method();
    }
}