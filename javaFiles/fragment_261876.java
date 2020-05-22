public static Function<Integer, Integer> right() {

    return new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer x) {
            if (x < 2) {
                return x;
            } else {
                return apply(x - 1) + apply(x - 2);
            }
        }
    };
}