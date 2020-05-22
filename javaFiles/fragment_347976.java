import scalaz.*;

public class JavaDisjunctionHelper {

    public static <A, B> $bslash$div<A, B> left(A a) {
        return new $minus$bslash$div(a);
    }

    public static <A, B> $bslash$div<A, B> right(B b) {
        return new $bslash$div$minus(b);
    }

    public static void main(String[] args) {
        $bslash$div<String, Integer> p = left("z");
        $bslash$div<String, Integer> q = right(3);
        System.out.println(p); // -\/("z")
        System.out.println(q); // \/-(3)
    }
}