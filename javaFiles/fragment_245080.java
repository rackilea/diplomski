import java.io.Serializable;
import java.util.Comparator;

public final class Generic {

    // Bad implementation, only used as an example.
    public static final Comparator<Integer> COMPARATOR = (a, b) -> (a > b) ? 1 : -1;

    public static Comparator<Integer> reference() {
        return (Comparator<Integer> & Serializable) COMPARATOR::compare;
    }

    public static Comparator<Integer> explicit() {
        return (Comparator<Integer> & Serializable) (a, b) -> COMPARATOR.compare(a, b);
    }

}