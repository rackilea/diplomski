import java.util.Comparator;
import java.util.List;

public class SortingUtils {
    public static <T> List<T> quickSort(List<T> list, Comparator<T> comparator) {
        return quickSort(list, comparator, 0, list.size() - 1);
    }

    public static <T extends Comparable<T>> List<T> quickSort(List<T> list) {
        return quickSort(list, 0, list.size() - 1);
    }

    private static <T> List<T> quickSort(List<T> list, Comparator<T> comparator, int left, int right) {
        int ll = left;
        int rr = right;

        if (rr > ll) {
            T pivot = list.get((ll + rr) / 2);
            while (ll <= rr) {
                while (ll < right && comparator.compare(list.get(ll),  pivot) < 0) {
                    ll += 1;
                }
                while (rr > left && comparator.compare(list.get(rr),  pivot) > 0) {
                    rr -= 1;
                }
                if (ll <= rr) {
                    swap(list, ll, rr);
                    ll += 1;
                    rr -= 1;
                }
            }
            if (left < rr)  quickSort(list, comparator, left, rr);
            if (ll < right) quickSort(list, comparator, ll, right);
        }

        return list;
    }

    private static <T extends Comparable<T>>List<T> quickSort(List<T> list, int left, int right) {
        int ll = left;
        int rr = right;

        if (rr > ll) {
            T pivot = list.get((ll + rr) / 2);
            while (ll <= rr) {
                while (ll < right && list.get(ll).compareTo(pivot) < 0) {
                    ll += 1;
                }
                while (rr > left && list.get(rr).compareTo(pivot) > 0) {
                    rr -= 1;
                }
                if (ll <= rr) {
                    swap(list, ll, rr);
                    ll += 1;
                    rr -= 1;
                }
            }
            if (left < rr)  quickSort(list, left, rr);
            if (ll < right) quickSort(list, ll, right);
        }

        return list;
    }

    private static <T> void swap(List<T> list, int left, int right) {
        T temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}