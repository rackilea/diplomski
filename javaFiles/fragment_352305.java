public class Merge {
    private Merge() {
    }

    private static <T extends Comparable<? super T>> boolean less(T v, T w) {
        int sign = v.compareTo(w);
        if (sign == 0) throw new IllegalArgumentException("Repeated points");
        return sign < 0;
    }


    private static <T extends Comparable<? super T>> void exch(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static <T extends Comparable<? super T>> void insertSort(T[] a, int lo, int hi) {

        for (int i = lo; i < hi + 1; ++i) {
            for (int j = i; j > lo; --j) {
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
                else
                    break;
            }
        }
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
        for (int k = lo; k != hi + 1; ++k) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k != hi + 1; ++k) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }


    private static <T extends Comparable<? super T>> void sort(T[] a, T[] aux, int lo, int hi) {
        if (hi <= lo + 6) {
            insertSort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        if (!less(a[mid + 1], a[mid])) return;
        merge(a, aux, lo, mid, hi);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a) {
        T[] aux = a.clone();
        sort(a, aux, 0, a.length - 1);
    }

}