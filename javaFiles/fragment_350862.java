TreeMap<String, T> myMap = new TreeMap<String, T>(new Comparator<String>() {
    public int compare(String lhs, String rhs) {
        /* See which of the inputs, if any, are ALL. */
        bool oneAll = lhs.equals("ALL");
        bool twoAll = rhs.equals("ALL");

        /* If both are ALL or neither are ALL, just do a normal comparison. */
        if (oneAll == twoAll) {
            return lhs.compareTo(rhs);
        }
        /* Otherwise, exactly one of them is ALL.  Determine which one it is and
         * react accordingly.
         */
        else if (oneAll) {
            return -1;
        } else {
            return +1;
        }
    }
});