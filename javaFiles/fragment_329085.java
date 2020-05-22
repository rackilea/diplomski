public static int range(final ArrayList<Integer> list) {
    if (list.isEmpty()) {
        return 0;
    } else {
        return (Collections.max(list) - Collections.min(list)) + 1;
    }
}