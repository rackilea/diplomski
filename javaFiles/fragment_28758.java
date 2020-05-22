import java.util.*;

class Example {
    public static void main(String[] args) {
        ArrayList<Exception> a = new ArrayList<Exception>();
        ArrayList<String>    b = new ArrayList<String>();

        System.out.println("ArrayList<Exception> class is:");
        System.out.println("\t" + a.getClass());
        System.out.println("ArrayList<String> class is:");
        System.out.println("\t" + b.getClass());
        System.out.println(
            "ArrayList<Exception> class == ArrayList<String> class:");
        System.out.println("\t" + ( a.getClass() == b.getClass() ));

        ArrayList<Exception>[] c = new ArrayList[0];
        ArrayList<String>[]    d = new ArrayList[0];

        System.out.println("ArrayList<Exception>[] class is:");
        System.out.println("\t" + c.getClass());
        System.out.println("ArrayList<String>[] class is:");
        System.out.println("\t" + d.getClass());
        System.out.println(
            "ArrayList<Exception>[] class == ArrayList<String>[] class:");
        System.out.println("\t" + ( c.getClass() == d.getClass() ));
    }
}