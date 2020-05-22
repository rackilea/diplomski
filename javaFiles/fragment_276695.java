SortedSet<String> s1 = new TreeSet<String>(new Comparator<String>() {
        /**
         * Returns a positive value if number1 is larger than number 2, a
         * negative number if number1 is less than number2, and 0 if they
         * are equal.
         */
        public int compare(String number1, String number2) {
            return Integer.parseInt(number1) - Integer.parseInt(number2);
        }
    });