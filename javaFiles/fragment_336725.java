static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
    Comparator<K> valueComparator = (k1, k2) -> {
        int compare = map.get(k2).compareTo(map.get(k1));
        if (compare == 0) return 1;
        else return compare;
    };
    Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
    sortedByValues.putAll(map);
    return sortedByValues;
}
static TreeMap<Action,Integer> mapMoves() {
    List<Action> directions = new ArrayList<>();
    directions.add(Action.DOWN);
    directions.add(Action.UP);
    directions.add(Action.UP);
    directions.add(Action.UP);
    directions.add(Action.LEFT);
    directions.add(Action.LEFT);
    directions.add(Action.RIGHT);
    directions.add(Action.RIGHT);
    TreeMap<Action,Integer> map = new TreeMap<>();
    for(Action a : directions){
        switch (a){
            case UP:
                map.put(a, 10);
                break;
            case DOWN:
                map.put(a, 2);
                break;
            case LEFT:
                map.put(a, 30);
                break;
            case RIGHT:
                map.put(a, 4);
                break;
        }
    }
    return map;
}

enum Action {
    UP, DOWN, LEFT, RIGHT
}