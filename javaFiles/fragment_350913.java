public class Ref {
    public static void main(String args[]) {
        Integer i = new Integer(4);
        i = passByRef(i);
        System.out.println(i);    // Prints 5.
    }

    static Integer passByRef(Integer j) {
        j = new Integer(5);
        return j;
    }
}