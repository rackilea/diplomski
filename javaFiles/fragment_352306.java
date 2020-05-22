public enum Merge {
    ;

    private static class Merger<T extends Comparable<? super T>> {
        private final T[] a;
        private final T[] aux;

        private Merger(T[] a) {
            this.a = a;
            aux = a.clone();
        }
        private boolean less(T v, T w) {
            int sign = v.compareTo(w);
            if (sign == 0) throw new IllegalArgumentException("Repeated points");
            return sign < 0;
        }

        private void exch(int i, int j) {
            T swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }

        private void insertSort(int lo, int hi) {

            for (int i = lo; i < hi + 1; ++i) {
                for (int j = i; j > lo; --j) {
                    if (less(a[j], a[j - 1]))
                        exch(j, j - 1);
                    else
                        break;
                }
            }
        }

        private void merge(int lo, int mid, int hi) {
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


        private void sort(int lo, int hi) {
            if (hi <= lo + 6) {
                insertSort(lo, hi);
                return;
            }
            int mid = lo + (hi - lo) / 2;
            sort(lo, mid);
            sort(mid + 1, hi);
            if (!less(a[mid + 1], a[mid])) return;
                merge(lo, mid, hi);
        }
        private void sort() {
            sort(0, a.length - 1);
        }
    }
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        new Merger<>(a).sort();
    }

}