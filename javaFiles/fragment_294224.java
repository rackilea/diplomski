import java.lang.Comparable;
public class CompareTester implements Comparable<CompareTester> {
    int i;

    public int compareTo(CompareTester o) {
        return this.i - o.i;
    }
}