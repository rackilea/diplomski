public int compare(T a, T b) {
            for (int i = 0; i < key.length; i++) {
                final Comparable<?> av = key[i].get(a), bv = key[i].get(b);
                final int cmp = doCompareTo(av, bv);
                if (cmp != 0) return cmp * dir[i];
            }
            return 0;
        }

        private <U extends Comparable<U>> int doCompareTo(U a, U b) {
            return a.compareTo(b);
        }