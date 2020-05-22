if (comparator == null) {
    comparator = new Comparator<E>() {
        @Override
        public int compare(E lhs, E rhs) {
            return lhs.compareTo(rhs);
        }
    };
}