public class Ref {
    public static void main(String args[]) {
        Integer i = new Integer(4);
        passByRef(i);
        System.out.println(i);    // Prints 4.
    }

    static void passByRef(Integer j) {
        j = new Integer(5);
    }
}