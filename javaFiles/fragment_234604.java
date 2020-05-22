Arrays.sort(standingsB, new Comparator<Double[]>() {
    public int compare(Double[] s1, Double[] s2) {
        if (s1[0] > s2[0])
            return 1;    // tells Arrays.sort() that s1 comes after s2
        else if (s1[0] < s2[0])
            return -1;   // tells Arrays.sort() that s1 comes before s2
        else {
            /*
             * s1 and s2 are equal.  Arrays.sort() is stable,
             * so these two rows will appear in their original order.
             * You could take it a step further in this block by comparing
             * s1[1] and s2[1] in the same manner, but it depends on how
             * you want to sort in that situation.
             */
            return 0;
        }
    }
};