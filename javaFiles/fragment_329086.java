public static int range(final ArrayList<Integer> list) {
    if (list.isEmpty()) {
        return 0;
    } else {
        int max = list.get(0);
        int min = list.get(0);
        for (final int i : list) {
            if (i > max) {
                max = i;
            } else if (i < min) {
                min = i;
            }
        }
        return (max - min) + 1;
    }
}