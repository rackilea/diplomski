public int compare(String o1, String o2) {
        int cmp = o1.compareToIgnoreCase(o2);
        if (cmp != 0) return cmp;

        return o1.compareTo(o2);
    }