public long sort(Comparable[] a) {
        if (a == null) {
            throw new IllegalArgumentException("argument 'array' must not be null.");
        }
        int N = a.length;
        int comparisonsCount = 0; // use this instead
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                comparisonsCount++; // edit here
                if(less(a[j], a[j-1]))
                    exch(a, j, j-1);      
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
        return comparisonsCount; // and here
    }