Predicate<Integer> evenFilter = new Predicate<Integer>() {
    public boolean apply(Integer i) {
        return (i % 2 == 0);
    }
};

Map<Integer, Integer> map = new HashMap<Integer, Integer>();

Map<Integer, Integer> evenMap = Maps.filterValues(map, evenFilter);