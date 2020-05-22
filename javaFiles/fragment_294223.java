import java.util.Comparator;
public class CompareTester {
    int i;
    public static class Inside implements Comparator<CompareTester> {
        @Override
        public int compare(CompareTester o1, CompareTester o2) {
            return o1.i - o2.i;
        }
    }
}