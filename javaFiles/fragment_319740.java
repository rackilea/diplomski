public enum StringComparator implements Comparator<String> {
    ORDINAL {
        @Override
        public int compare(final String s1, final String s2) {
            if (s1 == null) {
                return (s2 == null) ? 0 : -1;
            }
            if (s2 == null) {
                return 1;
            }
            return s1.compareTo(s2);
        }

        @Override
        public /* bridge */ int compare(final Object x0, final Object x1) {
            return this.compare((String)x0, (String)x1);
        }
    },
    ...
}